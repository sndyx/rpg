package net.aradiata.sfx.music

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import net.aradiata.util.ticks

abstract class LinearTrack : Track {

    abstract val length: Long

    private var isCancelled = false
    private var isFinished = false

    override suspend fun play() {
        channel.send(id)
        channel.send("$id.mono")
        var ticksCancelled = 0
        for(i in 0..(length / 50)) {
            delay(1.ticks)
            if (isCancelled) { // If cancelled fade out sound
                if (ticksCancelled == 0) {
                    channel.monoVolume = 1.0f
                } else if (ticksCancelled == 1) {
                    channel.cancel(id)
                }
                channel.monoVolume -= 0.01f
                if (channel.monoVolume <= 0) {
                    channel.cancel("$id.mono")
                    break
                }
                ticksCancelled++
            }
        }
        isFinished = true
    }

    override suspend fun stop(cause: String?) = coroutineScope {
        isCancelled = true
        while (!isFinished && isActive) { delay(50L) }
    }

}