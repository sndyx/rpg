package net.aradiata.utility

import java.nio.file.Path
import kotlin.script.experimental.api.SourceCode
import kotlin.script.experimental.host.FileScriptSource

fun Path.toScriptSource(): SourceCode {
    return FileScriptSource(toFile())
}