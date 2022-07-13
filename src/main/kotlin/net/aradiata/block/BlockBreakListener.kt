package net.aradiata.block

import net.aradiata.block.queue.DefaultBlockQueue
import net.aradiata.block.queue.StoneRegenQueue
import net.aradiata.item.Item
import net.aradiata.structure.PluginEnable
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

object BlockBreakListener : Listener, PluginEnable {

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.player.gameMode == GameMode.SURVIVAL) {
            val block: Block = event.block

            event.isCancelled = true
            val tool = Item.from(event.player.inventory.itemInMainHand)

            val drops: List<Item> = when(block.type) {
                in StoneRegenQueue.handles -> StoneRegenQueue.handleBlockBroken(tool, block)
                in DefaultBlockQueue.handles -> DefaultBlockQueue.handleBlockBroken(tool, block)
                else -> return
            }!!

            drops.forEach {
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