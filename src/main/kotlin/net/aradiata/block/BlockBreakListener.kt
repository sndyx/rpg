package net.aradiata.block

import net.aradiata.item.Item
import net.aradiata.item.impl.Dandelion
import net.aradiata.item.impl.bundle.GrassBreakBundle
import net.aradiata.plugin
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.BlockState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

object BlockBreakListener : Listener {
    
    val tasks: MutableList<BlockState> = mutableListOf()
    
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.player.gameMode == GameMode.SURVIVAL) {
            event.isCancelled = true
            val state = event.block.state
            val drops: List<Item> = when (event.block.type) {
                Material.GRASS -> GrassBreakBundle.next()
                Material.DANDELION -> Dandelion.next()
                else -> { return }
            }
            tasks.add(state)
            event.block.type = Material.AIR
            drops.forEach {
                event.block.world.dropItemNaturally(event.block.location, it.new())
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, {
                state.update(true)
                tasks.remove(state)
            }, 2400L)
        }
    }
    
}