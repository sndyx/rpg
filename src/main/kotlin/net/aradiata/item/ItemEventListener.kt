package net.aradiata.item

import kotlinx.coroutines.launch
import net.aradiata.PluginScope
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object ItemEventListener : Listener {
    
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (!event.hasItem()) return
        if (event.item?.itemMeta?.hasCustomModelData() != true) return
        when (event.action) {
            Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK -> {
                PluginScope.launch {
                    // call event
                }
            }
            Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK -> {
                PluginScope.launch {
                    // call event
                }
            }
            else -> { /* Ignore */ }
        }
    }
    
}