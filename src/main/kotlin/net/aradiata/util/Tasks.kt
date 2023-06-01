package net.aradiata.util

import net.aradiata.Plugin
import org.bukkit.Bukkit
import kotlin.time.Duration

fun Plugin.Companion.schedule(after: Duration = Duration.ZERO, action: () -> Unit): Int {
    return Bukkit.getScheduler().runTaskLater(
        instance,
        action,
        after.inWholeMilliseconds / 50
    ).taskId
}

fun Plugin.Companion.scheduleEvery(after: Duration, action: () -> Unit): Int {
    return Bukkit.getScheduler().runTaskTimer(
        instance,
        action,
        0,
        after.inWholeMilliseconds / 50
    ).taskId
}

fun Plugin.Companion.cancelTask(id: Int) {
    Bukkit.getScheduler().cancelTask(id)
}