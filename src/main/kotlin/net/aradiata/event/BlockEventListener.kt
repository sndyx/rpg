package net.aradiata.event

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.aradiata.PluginScope
import net.aradiata.plugin.sync
import net.minecraft.core.BlockPosition
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation
import net.minecraft.network.protocol.game.PacketPlayOutWorldEvent
import org.bukkit.Material
import org.bukkit.block.Block
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
            try {
                for (i in -1..9) {
                    distributeBlockProgress(event.player, event.block, i)

                    delay(100)
                }
                PluginScope.sync {
                    val blockParticlePacket = PacketPlayOutWorldEvent(
                        2001,
                        event.block.run { BlockPosition(x, y, z) },
                        net.minecraft.world.level.block.Block.i((event.block as CraftBlock).nms),
                        false
                    )

                    event.block.world.getNearbyEntities(event.block.location, 32.0, 32.0, 32.0) { it is Player }
                        .forEach {
                            (it as CraftPlayer).handle.b.a(blockParticlePacket)
                        }
                    event.block.type = Material.AIR
                    event.block.world.dropItemNaturally(event.block.location, ItemStack(Material.DIAMOND))
                }
            } finally {
                distributeBlockProgress(event.player, event.block, -1)
            }
        }
    }

    // Send -1 to mining player to resolve conflicts
    private fun distributeBlockProgress(player: Player, block: Block, progress: Int) {
        val blockPos: BlockPosition = block.run { BlockPosition(x, y, z) }

        val blockProgressPacket = PacketPlayOutBlockBreakAnimation(
            player.entityId, blockPos, progress
        )

        PluginScope.sync {
            block.world.getNearbyEntities(block.location, 32.0, 32.0, 32.0) { it is Player }
                .forEach {
                    (it as CraftPlayer).handle.b.a(
                        when (it) {
                            player -> PacketPlayOutBlockBreakAnimation(
                                -1, blockPos, progress
                            )
                            else -> blockProgressPacket
                        }
                    )
                }
        }
    }

    @EventHandler
    fun onBlockDamageAbort(event: BlockDamageAbortEvent) {
        jobs[event.player.uniqueId]?.cancel()
    }

    /*
    @EventHandler
    fun onPickaxeSwap(event: PlayerItemHeldEvent) {
        jobs[event.player.uniqueId]?.cancel()
    }

     */
    
}