package net.aradiata.item

import kotlinx.coroutines.launch
import net.aradiata.Plugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object ItemEventManager : Listener {
    
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (!event.hasItem()) return
        val item = event.item?.toItem() ?: return
        Plugin.launch {
            when (event.action) {
                Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK -> {
                    item.events.rightClick?.invoke(Plugin, event.player)
                }
                else -> {}
            }
        }
    }
    
}