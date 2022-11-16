package net.aradiata.player

import net.aradiata.Plugin
import net.aradiata.plugin.manaBar
import net.aradiata.plugin.scheduleEvery
import net.aradiata.plugin.ticks
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.GameMode

fun PlayerHandle.scheduleTasks() {
    jobs += Plugin.scheduleEvery(5.ticks) {
        if (player.gameMode != GameMode.CREATIVE) {
            player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                TextComponent((manaBar[(state.mana / state.maxMana * 20).toInt()]))
            )
        }
    }
    jobs += Plugin.scheduleEvery(10.ticks) {
        if (state.mana != state.maxMana) {
            state.mana += 1
        }
    }
}