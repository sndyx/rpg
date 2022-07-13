package net.aradiata.block

import net.aradiata.item.Item
import net.aradiata.structure.PluginEnable
import org.bukkit.block.Block
import org.bukkit.block.BlockState

interface BlockRegenQueue {
    fun handles(block: Block): Boolean

    fun handleBlockBroken(tool: Item?, block: Block): List<Item>?

    fun regenAll()

    fun init()

}