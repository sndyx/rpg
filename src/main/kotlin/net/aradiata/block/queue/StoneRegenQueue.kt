package net.aradiata.block.queue

import net.aradiata.PluginScope
import net.aradiata.plugin.scheduleEvery
import net.aradiata.plugin.sync
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import kotlin.random.Random
import kotlin.time.Duration.Companion.minutes

object StoneRegenQueue: BlockRegenQueue {
    
    private val stone: MutableList<Location> = mutableListOf()
    override val handled: List<Material> = listOf(Material.TUFF, Material.COAL_ORE)
    
    override fun queue(block: Block) {
        stone.add(block.location)
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
    
    fun init() {
        PluginScope.scheduleEvery(5.minutes) {
            PluginScope.sync {
                regenAll()
            }
        }
    }
    
}