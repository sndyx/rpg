package net.aradiata.event

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.aradiata.PluginScope
import net.aradiata.plugin.sync
import net.minecraft.core.BlockPosition
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation
import net.minecraft.network.protocol.game.PacketPlayOutWorldEvent
import net.minecraft.world.level.block.Block
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockDamageAbortEvent
import org.bukkit.event.block.BlockDamageEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*

object BlockEventListener : Listener {
    
    private val jobs = mutableMapOf<UUID, Job>()
    
    @EventHandler
    fun onBlockDamage(event: BlockDamageEvent) {
        if (event.instaBreak) return
        event.isCancelled = true
        event.player.addPotionEffect(PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1, false, false))
        jobs[event.player.uniqueId] = PluginScope.launch {
            for (i in -1..9) {
                val packet = PacketPlayOutBlockBreakAnimation(
                    0,
                    BlockPosition(event.block.x, event.block.y, event.block.z),
                    i
                )
                PluginScope.sync {
                    event.block.world.getNearbyEntities(event.block.location, 32.0, 32.0, 32.0) { it is Player }
                        .forEach {
                            (it as CraftPlayer).handle.b.a(packet)
                        }
                }
                delay(100)
            }
            PluginScope.sync {
                val packet = PacketPlayOutWorldEvent(
                    2001,
                    event.block.location.run { BlockPosition(x, y, z) },
                    Block.i((event.block as CraftBlock).nms),
                    false
                )
                event.block.world.getNearbyEntities(event.block.location, 32.0, 32.0, 32.0) { it is Player }.forEach {
                    (it as CraftPlayer).handle.b.a(packet)
                }
                event.block.type = Material.AIR
                event.block.world.dropItemNaturally(event.block.location, ItemStack(Material.DIAMOND))
            }
        }
    }
    
    @EventHandler
    fun onBlockDamageAbort(event: BlockDamageAbortEvent) {
        jobs[event.player.uniqueId]?.cancel()
        val packet = PacketPlayOutBlockBreakAnimation(
            0,
            BlockPosition(event.block.x, event.block.y, event.block.z),
            -1
        )
        event.block.world.getNearbyEntities(event.block.location, 32.0, 32.0, 32.0) { it is Player }.forEach {
            (it as CraftPlayer).handle.b.a(packet)
        }
    }
    
}