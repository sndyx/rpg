package net.aradiata.player

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
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
        players.removeAt(index).close()
    }
    
}