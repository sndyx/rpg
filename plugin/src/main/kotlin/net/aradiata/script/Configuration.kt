package net.aradiata.script

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.jvm.baseClassLoader
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm
import kotlin.script.experimental.jvm.lastSnippetClassLoader

object ItemCompilationConfiguration : ScriptCompilationConfiguration({
    defaultImports(
        "net.aradiata.script.*",
        "net.aradiata.item.*",
        "Plugin"
    )
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
})