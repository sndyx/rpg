package net.aradiata.sfx.music

import net.aradiata.Plugin
import net.aradiata.sfx.SoundChannel
import org.bukkit.util.BoundingBox

interface LocationTrackController : TrackController {

    val map: Map<BoundingBox, (SoundChannel) -> Track>

    override fun tick(channel: SoundChannel): Track? {
        val location = channel.player.location
        if (location.world != Plugin.world) return null
        map.entries.forEach {
            // it is very stupid that I have to do this, but I don't want to cast location to a vector
            if (it.key.contains(location.x, location.y, location.z)) {
                return it.value.invoke(channel)
            }
        }
        return null
    }

}