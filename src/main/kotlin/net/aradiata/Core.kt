package net.aradiata

import net.aradiata.command.ItemsCommand
import net.aradiata.dsl.loadAllItems
import net.aradiata.item.Item

lateinit var plugin: PluginCore

class PluginCore : Plugin() {
    
    var items: Map<String, Item>
    
    init {
        plugin = this
        items = loadAllItems()
        getCommand("items")!!.setExecutor(ItemsCommand)
    }
    
}
