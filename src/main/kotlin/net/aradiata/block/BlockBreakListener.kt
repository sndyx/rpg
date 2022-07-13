package net.aradiata.block

import net.aradiata.item.Item
import net.aradiata.item.impl.Coal
import net.aradiata.item.impl.Dandelion
import net.aradiata.bundles.item.GrassBreakBundle
import net.aradiata.bundles.item.WheatBreakBundle
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

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.player.gameMode == GameMode.SURVIVAL) {
            val block: Block = event.block

            event.isCancelled = true
            val tool = Item.from(event.player.inventory.itemInMainHand)

            val drops: List<Item>? = when {
                StoneRegenQueue.handles(block) -> StoneRegenQueue.handleBlockBroken(tool, block)
                DefaultBlockQueue.handles(block) -> DefaultBlockQueue.handleBlockBroken(tool, block)
                else -> return
            }

            drops?.forEach {
                block.world.dropItemNaturally(block.location, it.new())
            }

            event.block.type = Material.AIR
        }
    }

    override fun onEnable() {
        StoneRegenQueue.init()
        DefaultBlockQueue.init()
    }

    override fun onDisable() {
        StoneRegenQueue.regenAll()
        DefaultBlockQueue.regenAll()
    }

}