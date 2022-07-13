package net.aradiata.block

import net.aradiata.item.Item
import net.aradiata.item.impl.Coal
import net.aradiata.item.impl.Dandelion
import net.aradiata.item.impl.bundle.GrassBreakBundle
import net.aradiata.item.impl.bundle.WheatBreakBundle
import net.aradiata.plugin
import net.aradiata.structure.PluginEnable
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import kotlin.random.Random

object BlockBreakListener : Listener, PluginEnable {
    
    private val tasks: MutableList<BlockState> = mutableListOf()
    private val stone: MutableList<Location> = mutableListOf()
    
    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.player.gameMode == GameMode.SURVIVAL) {
            val block: Block = event.block

            event.isCancelled = true
            val tool = Item.from(event.player.inventory.itemInMainHand)
            val state = block.state
            val type = block.type

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

            drops.forEach {
                block.world.dropItemNaturally(block.location, it.new())
            }

            when (type) {
                Material.TUFF, Material.COAL_ORE -> stone.add(block.location)
                else -> {
                    tasks.add(state)
                    
                    while (Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, {
                        state.update(true)
                        tasks.remove(state)
                    }, 2400L) == -1) { /* Ignore */ }
                }
            }

            event.block.type = Material.AIR
        }
    }

    override fun onEnable() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, {
            stone.forEach {
                it.world?.getBlockAt(it)?.setType(when (Random.nextInt(1, 10)) {
                    1 -> Material.COAL_ORE
                    else -> Material.TUFF
                }, false)
            }
            stone.clear()
        }, 2400, 2400)
    }

    override fun onDisable() {
        tasks.forEach { it.update(true) }
    }

}