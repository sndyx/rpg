package net.aradiata.player

import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object PlayerManager : Listener {
    
    val players: MutableList<PlayerHandle> = mutableListOf()
    
    fun onJoin(event: PlayerJoinEvent) {
        players.add(PlayerHandle(event.player))
    }
    
    fun onQuit(event: PlayerQuitEvent) {
        players.removeIf { it.player.uniqueId == event.player.uniqueId }
    }
    
}