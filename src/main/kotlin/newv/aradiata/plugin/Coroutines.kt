package newv.aradiata.plugin

import kotlinx.coroutines.*
import newv.aradiata.PluginScope
import org.bukkit.Bukkit
import kotlin.time.Duration

fun <T : Any> sync(block: () -> T): T {
    return Bukkit.getScheduler().callSyncMethod(PluginScope.instance, block).get()
}

fun <T : Any> async(block: suspend CoroutineScope.() -> T): Deferred<T> {
    return PluginScope.async(block = block)
}

fun schedule(after: Duration, action: suspend () -> Unit) {
    PluginScope.launch {
        delay(after)
        action()
    }
}

fun scheduleEvery(after: Duration, action: suspend () -> Unit): Job {
    return PluginScope.launch {
        while (isActive) {
            delay(after)
            action()
        }
    }
}

inline fun <T, R : Any> parallelize(
    items: Collection<T>,
    crossinline action: suspend (T) -> R
): List<Deferred<R>> { // T̶h̶i̶s̶ ̶i̶s̶ ̶s̶t̶u̶p̶i̶d̶ This is awesome.
    return items.map {
        async { action(it) }
    }
}