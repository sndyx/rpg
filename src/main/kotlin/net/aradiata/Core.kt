package net.aradiata

import net.aradiata.block.BlockBreakListener
import net.aradiata.command.ItemsCommand
import org.bukkit.Bukkit

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    override fun onEnable() {
        plugin = this
        getCommand("items")!!.setExecutor(ItemsCommand)
        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)
        Bukkit.getPluginManager().registerEvents(BlockBreakListener, this)
    }
    
    override fun onDisable() {
        BlockBreakListener.tasks.forEach { it.update(true) }
    }
    
}
