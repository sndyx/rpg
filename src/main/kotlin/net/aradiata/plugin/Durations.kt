package net.aradiata.plugin

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

val Int.ticks: Duration get() = this.times(50).milliseconds

val Duration.inWholeTicks: Long get() =
    this.inWholeSeconds * 20