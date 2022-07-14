package net.aradiata.block.queue

import net.aradiata.item.Item
import org.bukkit.Material
import org.bukkit.block.Block

interface BlockRegenQueue {
    
    val handled: List<Material>
    
    fun handleBlockBroken(tool: Item?, block: Block): List<Item>?

    fun regenAll()

    fun init()

}