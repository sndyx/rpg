package net.aradiata.sfx

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import net.aradiata.Plugin
import net.aradiata.sfx.music.Track
import net.aradiata.util.cancelTask
import net.aradiata.util.schedule
import net.aradiata.util.scheduleEvery
import net.aradiata.util.ticks
import org.bukkit.SoundCategory
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import java.io.Closeable

class SoundChannel(val player: Player) : Closeable {

    private val entity = player.world.spawnEntity(player.eyeLocation, EntityType.INTERACTION)

    var track: Track? = null
    private var job: Job? = null
    private var current: Job? = null

    private var taskId: Int = 0

    var monoVolume = 0.0f

    init {
        taskId = Plugin.scheduleEvery(1.ticks) {
            if (player.world != Plugin.world) return@scheduleEvery
            entity.teleport(player.eyeLocation.add(0.0, 0.2 + (20 - monoVolume * 20), 0.0))
        }
    }

    fun play(queued: Track) {
        job?.cancel() // Cancel any current request, state has changed
        if (track?.id == queued.id && job == null) return // Don't try to repeat same track
        job = Plugin.launch {
            track?.stop(queued.id)
            if (isActive) { // Check if state changed while waiting
                monoVolume = 0.0f
                track = queued
                current = Plugin.launch { // Play song in new coroutine to avoid cancellation
                    queued.play()
                }
                job = null
            }
        }
    }

    fun stop() {
        job?.cancel()
        job = Plugin.launch {
            track?.stop()
            // Check if state changed while waiting before discarding track
            if (isActive) track = null
        }
    }

    fun send(sound: String) {
        val target = if (sound.endsWith(".mono")) entity else player
        Plugin.schedule {
            player.playSound(target, sound, SoundCategory.RECORDS, 1.0f, 1.0f)
        }
    }

    fun cancel(sound: String) {
        Plugin.schedule {
            player.stopSound(sound, SoundCategory.RECORDS)
        }
    }

    override fun close() {
        Plugin.cancelTask(taskId)
        job?.cancel()
        current?.cancel()
        entity.remove()
    }

}