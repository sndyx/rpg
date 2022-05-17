package net.aradiata.utility

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlin.reflect.KClass
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate
import kotlin.script.experimental.jvmhost.createJvmEvaluationConfigurationFromTemplate

fun jvmScriptingHost(
    builder: ScriptingHostBuilder.() -> Unit
): ScriptingHost =
    ScriptingHostBuilder().apply(builder).build()

@KotlinScript
open class ScriptBase

class ScriptEvaluationException(message: String) : RuntimeException(message)

interface ScriptingHost {
    
    fun <T> eval(data: InputStream): Result<T>
    
}

internal class ScriptingHostImpl(
    private val compilationConfiguration: ScriptCompilationConfiguration,
    private val evaluationConfiguration: ScriptEvaluationConfiguration,
) : ScriptingHost {
    
    private val engine = BasicJvmScriptingHost()
    
    @Suppress("Unchecked_Cast")
    override fun <T> eval(data: InputStream): Result<T> {
        val content = data.readBytes().decodeToString()
        val result = engine.eval(
            content.toScriptSource(),
            compilationConfiguration,
            evaluationConfiguration
        )
        return when (val value = result.valueOrNull()?.returnValue) {
            is ResultValue.Value -> {
                val byteOutputStream = ByteArrayOutputStream()
                val objectOutputStream = ObjectOutputStream(byteOutputStream)
                objectOutputStream.writeObject(value.value)
                val inputStream = ObjectInputStream(byteOutputStream.toByteArray().inputStream())
                val r = inputStream.readObject() as T
                Result.success(r)
            }
            is ResultValue.Unit, is ResultValue.NotEvaluated -> {
                runCatching { Unit as T }
            }
            is ResultValue.Error -> {
                Result.failure(
                    ScriptEvaluationException(value.error.message ?: "Script evaluation failed.")
                )
            }
            null -> Result.failure(ScriptEvaluationException(
                result.reports
                    .map { it.toString() }
                    .filter { !it.startsWith("DEBUG") }
                    .joinToString()
            ))
        }
    }
    
}

class ScriptingHostBuilder {
    
    private val configuration: ConfigurationBuilder =
        ConfigurationBuilder()
    
    fun configuration(
        builder: ConfigurationBuilder.() -> Unit
    ) {
        configuration.builder()
    }
    
    internal fun build(): ScriptingHost {
        val configurations = configuration.build()
        return ScriptingHostImpl(
            configurations.first,
            configurations.second,
        )
    }
    
}

class ConfigurationBuilder {
    
    private var imports: MutableList<String> =
        mutableListOf()
    
    @PublishedApi
    internal var implicitReceiver: KClass<*>? = null
    @PublishedApi
    internal var implicitReceiverInstance: Any? = null
    
    inline fun <reified T> implicitReceiver(value: T) {
        implicitReceiverInstance = value
        implicitReceiver = implicitReceiverInstance!!::class // ???
    }
    
    fun import(value: String) {
        imports.add(value)
    }
    
    internal fun build(): Pair<ScriptCompilationConfiguration, ScriptEvaluationConfiguration> {
        val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<ScriptBase> {
            defaultImports(imports)
            implicitReceiver?.let { implicitReceivers(it) }
        }
        val evaluationConfiguration = createJvmEvaluationConfigurationFromTemplate<ScriptBase> {
            implicitReceiverInstance?.let { implicitReceivers(it) }
        }
        return Pair(compilationConfiguration, evaluationConfiguration)
    }
    
}