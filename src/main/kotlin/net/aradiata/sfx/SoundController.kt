package net.aradiata.sfx

import net.aradiata.sfx.music.TestController
import org.bukkit.entity.Player

class SoundController(player: Player) {

    val channel = SoundChannel(player)

    companion object {
        val controllers = listOf(
            TestController
        )
    }

    fun tick() {
        controllers.forEach {
            it.update(channel)
        }
    }

}