package net.aradiata.script.host

import net.aradiata.Plugin
import net.aradiata.item.ItemRegistry
import net.aradiata.script.*
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.nio.file.Path
import kotlin.io.path.*
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.onFailure
import kotlin.script.experimental.api.valueOrNull
import kotlin.script.experimental.host.ScriptingHostConfiguration
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvm.baseClassLoader
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

val host = BasicJvmScriptingHost(
    ScriptingHostConfiguration {
        jvm {
            baseClassLoader.put(Plugin::class.java.classLoader)
        }
    }
)

fun evalAll(path: String) {
    Path(path).listDirectoryEntries()
        .filter { !it.isDirectory() }
        .forEach(::eval)
}

fun eval(path: Path) {
    println("Loading script $path")
    val id = path.name.substringBefore('.')
    val configuration = when (path.name.substringAfter('.')) {
        "resource.kts" -> createJvmCompilationConfigurationFromTemplate<ResourceFile>()
        "weapon.kts" -> createJvmCompilationConfigurationFromTemplate<WeaponFile>()
        "armor.kts" -> createJvmCompilationConfigurationFromTemplate<ArmorFile>()
        "pickaxe.kts" -> createJvmCompilationConfigurationFromTemplate<PickaxeFile>()
        "axe.kts" -> createJvmCompilationConfigurationFromTemplate<AxeFile>()
        else -> error("Unknown file extension")
    }
    host.eval(
        path.toFile().toScriptSource(), configuration, null
    ).onFailure { result ->
        println("Failed to load script $path!")
        result.reports.filter {
            it.severity == ScriptDiagnostic.Severity.FATAL
                    || it.severity == ScriptDiagnostic.Severity.ERROR
        }.forEach {
            println(it)
        }
    }.valueOrNull()?.let {
        val value = it.returnValue.scriptInstance
        // This is catastrophically bad, don't do this. Someone needs to fix this.
        // See JohnS or McJohn
        val bos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(bos)
        oos.writeObject(value)
        val ois = ObjectInputStream(bos.toByteArray().inputStream())
        val obj = ois.readObject() as ItemFile<*>
        ItemRegistry.add(obj.build(id))
    }
}