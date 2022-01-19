package net.aradiata.script

import java.nio.file.Path
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import kotlin.io.path.readText

val loader: ClassLoader by lazy { Thread.currentThread().contextClassLoader }

val engine: ScriptEngine =
    ScriptEngineManager(loader).getEngineByExtension("kts")

inline fun <reified T> runScript(script: String): T =
    run { engine.eval(script) }
        .takeIf { it is T }
        ?.let { it as T } ?: error("Unexpected result.")

inline fun <reified T> runScript(path: Path): T = runScript(path.readText())