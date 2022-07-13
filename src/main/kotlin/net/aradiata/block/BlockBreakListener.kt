package net.aradiata.block

import net.aradiata.item.Item
import net.aradiata.item.impl.Coal
import net.aradiata.item.impl.Dandelion
import net.aradiata.item.impl.bundle.GrassBreakBundle
import net.aradiata.item.impl.bundle.WheatBreakBundle
import net.aradiata.plugin
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.BlockState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

object BlockBreakListener : Listener {
    
    val tasks: MutableList<BlockState> = mutableListOf()
    val stone: MutableList<Location> = mutableListOf()
    
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.player.gameMode == GameMode.SURVIVAL) {
            event.isCancelled = true
            val tool = Item.from(event.player.inventory.itemInMainHand)
            val state = event.block.state
            val type = event.block.type
            val drops: List<Item> = when (type) {
                Material.GRASS -> GrassBreakBundle.next(tool)
                Material.DANDELION -> Dandelion.next(tool)
                Material.WHEAT -> WheatBreakBundle.next(tool)
                Material.TUFF -> emptyList()
                Material.COAL_ORE -> Coal.next(tool)
                else -> {
                    return
                }
            }
            tasks.add(state)
            event.block.type = Material.AIR
            drops.forEach {
                event.block.world.dropItemNaturally(event.block.location, it.new())
            }
            when (type) {
                Material.TUFF, Material.COAL_ORE -> stone.add(event.block.location)
                else -> {
                    while (Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, {
                        state.update(true)
                        tasks.remove(state)
                    }, 2400L) == -1) { /* Ignore */ }
                }
            }
        }
    }
    
}