package net.aradiata.player

import net.aradiata.Plugin
import net.aradiata.plugin.manaBar
import net.aradiata.plugin.scheduleEvery
import net.aradiata.plugin.ticks
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.GameMode
import org.bukkit.util.Vector
import java.awt.Color
import kotlin.math.atan2
import kotlin.math.floor

fun PlayerHandle.scheduleTasks() {
    jobs += Plugin.scheduleEvery(2.ticks) {
        
        val compassDirection = (floor(compassDirection(this) * 32).toInt() + 16) % 32
        val compassChar = (0xE109 + compassDirection).toChar()
        
        if (player.gameMode != GameMode.CREATIVE && player.gameMode != GameMode.SPECTATOR) {
            val message = TextComponent("\uE001$compassChar\uE002${(manaBar[(state.mana / state.maxMana * 20).toInt()])}")
            message.color = ChatColor.of(Color(255, 255, 255, 254))
            player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                TextComponent("\uE001$compassChar\uE002${(manaBar[(state.mana / state.maxMana * 20).toInt()])}")
            )
        }
    }
    jobs += Plugin.scheduleEvery(10.ticks) {
        if (state.mana != state.maxMana) {
            state.mana += 1
        }
    }
}

fun compassDirection(handle: PlayerHandle): Double {
    val direction = getAngleTo(
        handle.player.location.toVector(),
        handle.player.compassTarget.toVector()
    )
    val yaw = floorMod((handle.player.location.yaw / 360.0F).toDouble(), 1.0)
    handle.state.updateCompass(0.5 - (yaw - 0.25))
    val f = direction + handle.state.compassRot
    return floorMod(f, 1.0)
}

private fun getAngleTo(entity: Vector, pos: Vector): Double {
    return atan2(pos.z - entity.z, pos.x - entity.x) / 6.2831854820251465
}

private fun PlayerState.updateCompass(target: Double) {
    var e: Double = target - compassRot
    e = floorMod(e + 0.5, 1.0) - 0.5
    compassSpeed += e * 0.1
    compassSpeed *= 0.8
    compassRot = floorMod(compassRot + compassSpeed, 1.0)
}
private fun floorMod(dividend: Double, divisor: Double): Double {
    return (dividend % divisor + divisor) % divisor
}