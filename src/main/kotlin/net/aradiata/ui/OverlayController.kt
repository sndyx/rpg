package net.aradiata.ui

import net.md_5.bungee.api.ChatMessageType
import org.bukkit.entity.Player

class OverlayController(private val player: Player) {

    val stack = FixedStackComponent(mutableListOf())

    fun tick() {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, *stack.render().result)
    }

}