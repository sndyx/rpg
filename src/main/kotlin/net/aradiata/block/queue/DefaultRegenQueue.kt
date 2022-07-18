package net.aradiata.block.queue

import net.aradiata.PluginScope
import net.aradiata.plugin.schedule
import net.aradiata.plugin.sync
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import kotlin.time.Duration.Companion.minutes

object DefaultRegenQueue: BlockRegenQueue {
    
    private val blocks: MutableList<BlockState> = mutableListOf()
    
    override val handled: List<Material> = listOf(Material.WHEAT, Material.GRASS, Material.OAK_WOOD)
    
    override fun queue(block: Block) {
        val state = block.state
        blocks.add(state)
        PluginScope.schedule(2.minutes) {
            PluginScope.sync {
                state.update(true)
                blocks.remove(state)
            }
        }
    }
    
    override fun regenAll() {
        blocks.forEach { it.update(true) }
        blocks.clear()
    }
    
}