package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.utility.toScriptSource
import java.nio.file.Path
import kotlin.io.path.name
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

annotation class Delegate(val delegate: KClass<*>)

class ItemScriptCompilationConfiguration(private val delegate: KClass<*>) : ScriptCompilationConfiguration({
    defaultImports(
        "net.aradiata.dsl.*",
        "net.aradiata.item.Rarity.*"
    )
    implicitReceivers(delegate)
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
    ide {
        acceptedLocations(ScriptAcceptedLocation.Everywhere)
    }
})

class ItemScriptEvaluationConfiguration(private val delegate: ItemDelegate) : ScriptEvaluationConfiguration({
    implicitReceivers(delegate)
})

inline fun <reified T : Any> runScript(path: Path): Result<Item> {
    val delegate: KClass<*> = (T::class.annotations
        .find { it is Delegate } as? Delegate)!!.delegate
    
    val delegateInstance = delegate.createInstance() as ItemDelegate
    
    BasicJvmScriptingHost().eval(
        path.toScriptSource(),
        ItemScriptCompilationConfiguration(delegate),
        ItemScriptEvaluationConfiguration(delegateInstance)
    ).onFailure { result ->
        println("Failed to load `${path.name}`!\n" + result.reports
            .map { it.toString() }
            .filter { !it.startsWith("DEBUG") }
            .joinToString("\n")
        )
        return Result.failure(IllegalArgumentException())
    }
    
    return runCatching {
        delegateInstance.checkProperties()
        delegateInstance.toItem()
    }
}