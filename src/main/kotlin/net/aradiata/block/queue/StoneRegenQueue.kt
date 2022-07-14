package net.aradiata.block.queue

import net.aradiata.item.Item
import net.aradiata.item.impl.Coal
import net.aradiata.plugin
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import kotlin.random.Random

object StoneRegenQueue: BlockRegenQueue {

    private val stone: MutableList<Location> = mutableListOf()
    
    override val handled: List<Material> = listOf(Material.TUFF, Material.STONE)
    
    override fun handleBlockBroken(tool: Item?, block: Block): List<Item>? {
        stone.add(block.location)

        return when (block.type) {
            Material.TUFF -> emptyList()
            Material.COAL_ORE -> Coal.next(tool)
            else -> null
        }
    }

    override fun regenAll() {
        stone.forEach {
            it.world?.getBlockAt(it)?.setType(when (Random.nextInt(1, 10)) {
                1 -> Material.COAL_ORE
                else -> Material.TUFF
            }, false)
        }
        stone.clear()
    }

    override fun init() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, {
            regenAll()
        }, 2400, 2400)
    }
}