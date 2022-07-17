package net.aradiata.block

import org.bukkit.Material
import org.bukkit.block.Block
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class BlockData(val intent: ToolIntent, val strength: Int, val duration: Duration) {
    
    companion object {
        
        val Block.rpgData: BlockData?
            get() = blocks[type]
    
        private val blocks = mapOf(
            Material.STONE to BlockData(ToolIntent.Pickaxe, 0, 7.5.seconds),
            Material.BEDROCK to BlockData(ToolIntent.Pickaxe, 0, 3.seconds),
            Material.COAL_ORE to BlockData(ToolIntent.Pickaxe, 10, 7.5.seconds),
            Material.OAK_WOOD to BlockData(ToolIntent.Axe, 0, 5.seconds)
        )
        
    }
    
}

enum class ToolIntent {
    
    Any,
    Pickaxe,
    Axe,
    Hoe
    
}