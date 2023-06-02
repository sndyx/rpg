package net.aradiata.text

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.aradiata.Plugin
import java.nio.file.Path
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.readText


private val locales: Map<String, Map<String, String>> =
    Path.of(Plugin::class.java.getResource("/lang")!!.toURI())
        .listDirectoryEntries()
        .associate { Pair(it.nameWithoutExtension, Json.decodeFromString(it.readText())) }

private val english = locales["en_us"]!!


fun localize(key: String, locale: String, vararg args: String): String {
    val map = locales[locale] ?: english
    val string = map[key] ?: english[key]
    return string?.format(args) ?: key
}