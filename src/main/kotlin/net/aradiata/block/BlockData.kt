package net.aradiata.block

import org.bukkit.Material
import org.bukkit.block.Block
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class BlockData(val strength: Int, val duration: Duration) {
    
    companion object {
        
        val Block.rpgData: BlockData?
            get() = blocks[type]
    
        private val blocks = mapOf(
            Material.STONE to BlockData(0, 7.5.seconds),
            Material.BEDROCK to BlockData(0, 3.seconds),
            Material.COAL_ORE to BlockData(10, 7.5.seconds)
        )
        
    }
    
}