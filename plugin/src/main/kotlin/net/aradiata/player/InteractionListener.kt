package net.aradiata.player

import kotlinx.coroutines.launch
import net.aradiata.Plugin
import net.aradiata.item.toItem
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

object InteractionListener : Listener {
    
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
    
    @EventHandler
    fun onHit(event: EntityDamageByEntityEvent) {
        if (event.entity !is LivingEntity) return
        if (event.damager is Player) {
            event.damage = (event.damager as Player).damageTo(event.entity as LivingEntity)
        }
    }
    
}