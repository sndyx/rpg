package net.aradiata

import net.aradiata.command.ItemsCommand
import net.aradiata.dsl.loadItems
import net.aradiata.item.Item

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    var items: Map<String, Item> = mapOf()
    
    override fun onEnable() {
        plugin = this
        items = loadItems()
        getCommand("items")!!.setExecutor(ItemsCommand)
    }
    
}
