package net.aradiata.plugin

import kotlinx.coroutines.*
import net.aradiata.Plugin
import org.bukkit.Bukkit
import kotlin.time.Duration

fun <T : Any> Plugin.Companion.sync(block: () -> T): T {
    return Bukkit.getScheduler().callSyncMethod(instance, block).get()
}

fun Plugin.Companion.schedule(after: Duration, action: suspend () -> Unit) {
    launch {
        delay(after)
        action()
    }
}

fun Plugin.Companion.scheduleEvery(after: Duration, action: suspend () -> Unit): Job {
    return Plugin.launch {
        while (isActive) {
            delay(after)
            action()
        }
    }
}

inline fun <T, R : Any> Plugin.Companion.parallelize(
    items: Collection<T>,
    crossinline action: suspend (T) -> R
): List<Deferred<R>> { // T̶h̶i̶s̶ ̶i̶s̶ ̶s̶t̶u̶p̶i̶d̶ This is awesome.
    return items.map {
        async { action(it) }
    }
}