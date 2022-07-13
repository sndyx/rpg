package net.aradiata.block.queue

import net.aradiata.item.Item
import org.bukkit.block.Block

interface BlockRegenQueue {
    fun handles(block: Block): Boolean

    fun handleBlockBroken(tool: Item?, block: Block): List<Item>?

    fun regenAll()

    fun init()

}