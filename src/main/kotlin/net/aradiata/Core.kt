package net.aradiata

import net.aradiata.block.BlockBreakListener
import net.aradiata.command.ItemsCommand
import org.bukkit.Bukkit
import org.bukkit.Material
import kotlin.random.Random

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    override fun onEnable() {
        plugin = this
        getCommand("items")!!.setExecutor(ItemsCommand)
        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)
        Bukkit.getPluginManager().registerEvents(BlockBreakListener, this)
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, {
            BlockBreakListener.stone.forEach {
                it.world?.getBlockAt(it)?.setType(when (Random.nextInt(1, 10)) {
                    1 -> Material.COAL_ORE
                    else -> Material.TUFF
                }, false)
            }
            BlockBreakListener.stone.clear()
        }, 2400, 2400)
    }
    
    override fun onDisable() {
        BlockBreakListener.tasks.forEach { it.update(true) }
    }
    
}
