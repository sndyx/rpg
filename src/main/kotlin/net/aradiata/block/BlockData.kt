package net.aradiata.block

import net.aradiata.item.Bundle
import net.aradiata.item.bundle.EmptyBundle
import net.aradiata.item.bundle.GrassBundle
import net.aradiata.item.bundle.WheatBundle
import net.aradiata.item.type.Coal
import net.aradiata.item.type.OakWood
import org.bukkit.Material
import org.bukkit.block.Block
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class BlockData(val intent: ToolIntent, val strength: Int, val duration: Duration, val drops: Bundle) {
    
    companion object {
        
        val Block.rpgData: BlockData?
            get() = blocks[type]
    
        private val blocks = mapOf(
            Material.TUFF to pickaxe(10, 7.5.seconds, EmptyBundle),
            Material.BEDROCK to pickaxe(20, 4.seconds, EmptyBundle),
            Material.COAL_ORE to pickaxe(10, 7.5.seconds, Coal),
            Material.OAK_WOOD to axe(10, 5.seconds, OakWood),
            Material.SPRUCE_WOOD to axe(10, 5.seconds, OakWood),
            Material.DARK_OAK_WOOD to axe(10, 5.seconds, OakWood),
            Material.MANGROVE_WOOD to axe(10, 5.seconds, OakWood),
            Material.ACACIA_WOOD to axe(10, 5.seconds, OakWood),
            Material.BIRCH_WOOD to axe(10, 5.seconds, OakWood),
            Material.JUNGLE_WOOD to axe(10, 5.seconds, OakWood),
            Material.OAK_LEAVES to any(1.seconds, EmptyBundle),
            Material.SPRUCE_LEAVES to any(1.seconds, EmptyBundle),
            Material.DARK_OAK_LEAVES to any(1.seconds, EmptyBundle),
            Material.MANGROVE_LEAVES to any(1.seconds, EmptyBundle),
            Material.ACACIA_LEAVES to any(1.seconds, EmptyBundle),
            Material.JUNGLE_LEAVES to any(1.seconds, EmptyBundle),
            Material.AZALEA_LEAVES to any(1.seconds, EmptyBundle),
            Material.FLOWERING_AZALEA_LEAVES to any(1.seconds, EmptyBundle),
            Material.GRASS to any(drops = GrassBundle),
            Material.WHEAT to hoe(drops = WheatBundle),
        )
        
        private fun pickaxe(strength: Int, time: Duration, drops: Bundle) = BlockData(ToolIntent.Pickaxe, strength, time, drops)
        private fun axe(strength: Int, time: Duration, drops: Bundle) = BlockData(ToolIntent.Axe, strength, time, drops)
        private fun hoe(time: Duration = Duration.ZERO, drops: Bundle) = BlockData(ToolIntent.Hoe, 0, time, drops)
        private fun any(time: Duration = Duration.ZERO, drops: Bundle) = BlockData(ToolIntent.Any, 0, time, drops)
    
    
    }
    
}

enum class ToolIntent {
    
    Any,
    Pickaxe,
    Axe,
    Hoe
    
}