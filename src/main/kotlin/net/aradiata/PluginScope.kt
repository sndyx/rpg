package net.aradiata

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import net.aradiata.block.BlockEventListener
import net.aradiata.block.queue.DefaultRegenQueue
import net.aradiata.block.queue.StoneRegenQueue
import net.aradiata.command.ItemsCommand
import net.aradiata.command.RegenAllCommand
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import kotlin.coroutines.CoroutineContext

class PluginScope : JavaPlugin() {
    
    companion object : CoroutineScope {
        
        lateinit var instance: PluginScope
        
        @OptIn(DelicateCoroutinesApi::class)
        override val coroutineContext: CoroutineContext =
            newFixedThreadPoolContext(Config.threadCount, "worker-thread")
        
    }
    
    override fun onEnable() {
        instance = this
        getCommand("items")!!.setExecutor(ItemsCommand)
        getCommand("regenAll")!!.setExecutor(RegenAllCommand)

        Bukkit.getPluginManager().registerEvents(ItemsCommand, this)
        Bukkit.getPluginManager().registerEvents(BlockEventListener, this)
        StoneRegenQueue.init()
    }
    
    override fun onDisable() {
        DefaultRegenQueue.regenAll()
        StoneRegenQueue.regenAll()
    }

}