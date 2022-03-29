package net.aradiata

lateinit var plugin: Plugin

class PluginCore : Plugin() {
    
    init {
        plugin = this
    }
    
}
