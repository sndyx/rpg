package net.aradiata.player

import kotlinx.coroutines.cancel
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerGameModeChangeEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

fun Player.handle(): PlayerHandle {
    return PlayerManager.players.first {
        it.player.uniqueId == uniqueId
    }
}

object PlayerManager : Listener {
    
    val players: MutableList<PlayerHandle> = mutableListOf()
    
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        players.add(PlayerHandle(event.player))
    }
    
    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        val index = players.indexOfFirst { it.player.uniqueId == event.player.uniqueId }
        if (index == -1) return
        players.removeAt(index).cancel()
    }
    
    @EventHandler
    fun onGameModeChange(event: PlayerGameModeChangeEvent) {
        if (event.newGameMode == GameMode.CREATIVE) {
            event.player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                TextComponent("")
            )
        }
    }
    
}