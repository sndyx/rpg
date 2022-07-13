package net.aradiata

import net.aradiata.block.BlockBreakListener
import net.aradiata.command.ItemsCommand
import net.aradiata.player.JoinLeaveListener
import net.aradiata.structure.PluginEnable
import org.bukkit.Bukkit
import org.bukkit.event.Listener

lateinit var plugin: PluginCore

class PluginCore : Plugin() {

    val listeners: List<Listener>
        get() = listOf(BlockBreakListener, JoinLeaveListener)

    override fun onEnable() {
        plugin = this

        getCommand("items")!!.setExecutor(ItemsCommand)
        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)

        for (listener in listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this)

            if (listener is PluginEnable) {
                listener.onEnable()
            }
        }
    }
    
    override fun onDisable() {
        for (listener in listeners) {
            if (listener is PluginEnable) {
                listener.onDisable()
            }
        }
    }
    
}
