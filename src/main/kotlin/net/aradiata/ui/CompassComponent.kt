package net.aradiata.ui

import net.aradiata.math.fmod1
import net.aradiata.text.NO_OUTLINE
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player
import kotlin.math.atan2
import kotlin.math.floor

class CompassComponent(private val player: Player) : FixedComponent {

    private var rotation = 0.0
    private var speed = 0.0

    override val x: Int = -8

    override fun render(): RenderResult {
        val angle = atan2(
                player.compassTarget.z - player.location.z,
                player.compassTarget.x - player.location.x
        ) / 6.2831854820251465
        val yaw = fmod1(player.location.yaw / 360.0)
        updateCompass(0.5 - (yaw - 0.25))
        val direction = fmod1(angle + rotation)
        val ordinal = (floor(direction * 32).toInt() + 16) % 32
        val char = '\uE109' + ordinal
        val text = TextComponent(char.toString())
        text.color = NO_OUTLINE
        return RenderResult(arrayOf(text), 16)
    }

    private fun updateCompass(target: Double) {
        var e = target - rotation
        e = fmod1(e + 0.5) - 0.5
        speed += e * 0.1
        speed *= 0.8
        rotation = fmod1(rotation + speed)
    }

}