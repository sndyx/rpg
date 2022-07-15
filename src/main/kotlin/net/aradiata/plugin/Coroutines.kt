package net.aradiata.plugin

import kotlinx.coroutines.*
import net.aradiata.PluginScope
import org.bukkit.Bukkit
import kotlin.time.Duration

fun <T : Any> PluginScope.Companion.sync(block: () -> T): T {
    return Bukkit.getScheduler().callSyncMethod(instance, block).get()
}

fun PluginScope.Companion.schedule(after: Duration, action: suspend () -> Unit) {
    launch {
        delay(after)
        action()
    }
}

fun PluginScope.Companion.scheduleEvery(after: Duration, action: suspend () -> Unit): Job {
    return PluginScope.launch {
        while (isActive) {
            delay(after)
            action()
        }
    }
}

inline fun <T, R : Any> PluginScope.Companion.parallelize(
    items: Collection<T>,
    crossinline action: suspend (T) -> R
): List<Deferred<R>> { // T̶h̶i̶s̶ ̶i̶s̶ ̶s̶t̶u̶p̶i̶d̶ This is awesome.
    return items.map {
        async { action(it) }
    }
}