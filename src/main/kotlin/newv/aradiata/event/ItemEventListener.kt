package newv.aradiata.event

import newv.aradiata.plugin.async
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
                async {
                    // call event
                }
            }
            Action.LEFT_CLICK_AIR, Action.LEFT_CLICK_BLOCK -> {
                async {
                    // call event
                }
            }
            else -> { /* Ignore */ }
        }
    }
    
}