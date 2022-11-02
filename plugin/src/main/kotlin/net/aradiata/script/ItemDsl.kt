package net.aradiata.script

import kotlin.annotation.AnnotationRetention.BINARY
import kotlin.annotation.AnnotationTarget.*

@DslMarker
@Target(CLASS, TYPE)
@Retention(BINARY)
annotation class ItemDsl