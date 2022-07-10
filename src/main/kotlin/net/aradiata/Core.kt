package net.aradiata

import net.aradiata.command.ItemsCommand
import org.bukkit.Bukkit

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    override fun onEnable() {
        plugin = this
        getCommand("items")!!.setExecutor(ItemsCommand)
        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)
    }
    
}
