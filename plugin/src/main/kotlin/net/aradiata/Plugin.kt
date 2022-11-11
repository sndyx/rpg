package net.aradiata

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import net.aradiata.command.ItemsCommand
import net.aradiata.item.ItemEventManager
import net.aradiata.item.loadItems
import net.aradiata.player.PlayerManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import kotlin.coroutines.CoroutineContext

class Plugin : JavaPlugin() {
    
    companion object : CoroutineScope {
        
        lateinit var instance: Plugin
        
        @OptIn(DelicateCoroutinesApi::class)
        override val coroutineContext: CoroutineContext =
            newFixedThreadPoolContext(Config.threadCount, "worker-thread")
        
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
        Bukkit.getPluginManager().registerEvents(ItemEventManager, this)
    }

}