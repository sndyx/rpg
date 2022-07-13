package net.aradiata.player

import net.aradiata.item.Items
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object JoinLeaveListener : Listener {
    
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val data = PlayerData(event.player)
        if (event.player.gameMode == GameMode.SURVIVAL) {
            data.activeProfile.inventory.forEachIndexed { index, item ->
                event.player.inventory.setItem(index, Items.registry.values.find { it.configId == item?.id }?.new()?.apply { amount = item!!.count })
            }
        }
    }
    
    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        val data = PlayerData(event.player)
        data.activeProfile = serializePlayerData(event.player)
        if (event.player.gameMode == GameMode.SURVIVAL) event.player.inventory.clear()
    }
    
}