package net.aradiata.serialization

import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.notExists
import kotlin.io.path.writeText

object JoinLeaveListener : Listener {
    
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val folder = Path("rpg/players/${event.player.uniqueId}")
        if (folder.notExists()) {
            folder.createDirectory()
            folder.resolve("meta.json").writeText(buildJsonObject {
                put("name", event.player.name)
                put("rank", )
            }.toString())
        }
    }
    
    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
    
    }
    
}