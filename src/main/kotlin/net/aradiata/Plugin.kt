package net.aradiata

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.serialization.json.Json
import net.aradiata.command.ToggleUI
import net.aradiata.player.PlayerManager
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.plugin.java.JavaPlugin
import kotlin.coroutines.CoroutineContext

class Plugin : JavaPlugin() {

    companion object : CoroutineScope {
        @OptIn(DelicateCoroutinesApi::class)
        override val coroutineContext: CoroutineContext = newFixedThreadPoolContext(4, "rpg-worker")

        lateinit var instance: Plugin
        lateinit var world: World

        val json = Json { prettyPrint = true }
    }

    override fun onEnable() {
        instance = this
        world = Bukkit.getWorld("main")!!
        Bukkit.getPluginManager().registerEvents(PlayerManager, this)
        getCommand("toggleui")?.setExecutor(ToggleUI)
    }
    
    override fun onDisable() {
        PlayerManager.close()
    }

}