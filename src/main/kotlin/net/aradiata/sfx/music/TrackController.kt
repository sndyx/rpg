package net.aradiata.sfx.music

import net.aradiata.sfx.SoundChannel

interface TrackController {

    val handled: List<String>

    // Called every 20 ticks
    fun tick(channel: SoundChannel): Track?

    fun update(channel: SoundChannel) {
        val track = tick(channel)
        if (track == null) {
            if (channel.track?.id in handled) {
                channel.stop()
            }
        } else {
            channel.play(track)
        }
    }

}