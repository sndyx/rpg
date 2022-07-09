package net.aradiata

import net.aradiata.item.Item

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    override fun onEnable() {
        plugin = this
        getCommand("items")!!.setExecutor(ItemsCommand)
    }
    
}
