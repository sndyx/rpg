package net.aradiata.block.queue

import org.bukkit.Material
import org.bukkit.block.Block

interface BlockRegenQueue {
    
    val handled: List<Material>
    
    fun queue(block: Block)
    
    fun regenAll()
    
}