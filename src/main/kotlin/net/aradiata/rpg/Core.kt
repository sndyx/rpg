package net.aradiata.rpg

lateinit var plugin: Plugin

class PluginCore : Plugin() {
    
    init {
        plugin = this
    }
    
}