package net.aradiata.script

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

object ItemCompilationConfiguration : ScriptCompilationConfiguration({
    defaultImports(
        "net.aradiata.script.*",
        "net.aradiata.item.*",
        "net.aradiata.Plugin"
    )
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
})