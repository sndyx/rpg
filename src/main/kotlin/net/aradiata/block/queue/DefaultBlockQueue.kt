package net.aradiata.block.queue

import net.aradiata.bundles.item.GrassBreakBundle
import net.aradiata.bundles.item.WheatBreakBundle
import net.aradiata.item.Item
import net.aradiata.item.impl.Dandelion
import net.aradiata.item.impl.TheHoeOfAllHoes
import net.aradiata.plugin
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.inventory.ItemStack

object DefaultBlockQueue: BlockRegenQueue {
    
    private val blocks: MutableList<BlockState> = mutableListOf()
    
    override val handled: List<Material> = listOf(Material.DANDELION, Material.WHEAT, Material.GRASS, Material.WARPED_ROOTS)
    
    override fun handleBlockBroken(tool: Item?, block: Block): List<Item>? {
        val state = block.state
        blocks.add(state)

        //so bruh
        while (true) {
            if (Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, {
                state.update(true)
                blocks.remove(state)
            }, 2400L) != -1) {
                break
            }
        }

        return when (block.type) {
            Material.GRASS -> GrassBreakBundle.next(tool)
            Material.DANDELION -> Dandelion.next(tool)
            Material.WHEAT -> WheatBreakBundle.next(tool)
            Material.WARPED_ROOTS -> TheHoeOfAllHoes.next(tool)
            else -> null
        }
    }

    override fun regenAll() {
        blocks.forEach { it.update(true) }
    }

    override fun init() {
    }
}