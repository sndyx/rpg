package net.aradiata.player

import net.minecraft.world.item.ItemArmor
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerItemHeldEvent

object StateListener : Listener {
    
    @EventHandler
    fun onInventoryChange(event: InventoryClickEvent) {
        if (event.isShiftClick) { // unfortunately we must do this
            (event.whoClicked as Player).handle().updateArmor()
            (event.whoClicked as Player).handle().state.weaponFlag = true
        } else if (event.slotType == InventoryType.SlotType.ARMOR) {
            (event.whoClicked as Player).handle().updateArmor()
        } else {
            (event.whoClicked as Player).handle().state.weaponFlag = true
        }
    }
    
    @EventHandler
    fun onHeldItemChange(event: PlayerItemHeldEvent) {
        event.player.handle().state.weaponFlag = true
    }
    
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        when (event.action) {
            Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK -> {
                val item = event.item ?: return
                if (CraftItemStack.asNMSCopy(item).c() is ItemArmor) {
                    event.player.handle().updateArmor()
                }
            }
            else -> return
        }
    }
    
}