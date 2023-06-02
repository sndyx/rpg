package net.aradiata.player

import net.aradiata.Plugin
import net.aradiata.util.scheduleEvery
import net.aradiata.util.ticks
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLocaleChangeEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.io.Closeable

object PlayerManager : Listener, Closeable {

    val players = mutableListOf<PlayerController>()

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        players.add(PlayerController(event.player))
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        players.removeAt(players.indexOfFirst { it.player == event.player }).close()
    }

    @EventHandler
    fun onLocaleChange(event: PlayerLocaleChangeEvent) {
        event.player.locale
    }

    init {
        Plugin.scheduleEvery(1.ticks) {
            players.forEach(PlayerController::tick)
        }
    }

    override fun close() {
        players.forEach(PlayerController::close)
    }

}

val Player.controller get() = PlayerManager.players.first { it.player == this }