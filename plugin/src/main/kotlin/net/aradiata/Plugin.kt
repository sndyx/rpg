package net.aradiata

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.newFixedThreadPoolContext
import net.aradiata.command.ItemsCommand
import net.aradiata.item.loadItems
import net.aradiata.player.InteractionListener
import net.aradiata.player.PlayerManager
import net.aradiata.player.StateListener
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin
import kotlin.coroutines.CoroutineContext

class Plugin : JavaPlugin() {
    
    companion object : CoroutineScope {
        
        lateinit var instance: Plugin
        lateinit var world: World
        
        @OptIn(DelicateCoroutinesApi::class)
        override val coroutineContext: CoroutineContext =
            newFixedThreadPoolContext(4, "worker-thread")
        
        fun log(message: String) {
            instance.logger.info(message)
        }
        
    }
    
    override fun onEnable() {
        instance = this
        loadItems()
        getCommand("items")!!.setExecutor(ItemsCommand)
        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)
        Bukkit.getPluginManager().registerEvents(PlayerManager, this)
        Bukkit.getPluginManager().registerEvents(InteractionListener, this)
        Bukkit.getPluginManager().registerEvents(StateListener, this)
    }
    
    override fun onDisable() {
        PlayerManager.players.forEach { it.cancel() }
    }

}