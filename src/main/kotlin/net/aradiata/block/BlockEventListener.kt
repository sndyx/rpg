package net.aradiata.block

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.aradiata.block.BlockData.Companion.rpgData
import net.aradiata.PluginScope
import net.aradiata.block.queue.DefaultRegenQueue
import net.aradiata.block.queue.StoneRegenQueue
import net.aradiata.item.Axe
import net.aradiata.item.Hoe
import net.aradiata.item.Item
import net.aradiata.item.Item.Companion.toRpgItem
import net.aradiata.item.Pickaxe
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
import kotlin.time.Duration

object BlockEventListener : Listener {
    
    private val jobs = mutableMapOf<UUID, Job>()
    
    @EventHandler
    fun onBlockDamage(event: BlockDamageEvent) {
        event.isCancelled = true
        event.player.addPotionEffect(PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1, false, false))
        val data = event.block.rpgData ?: return
        val tool = when (data.intent) {
            ToolIntent.Any -> null
            ToolIntent.Pickaxe -> event.itemInHand.toRpgItem() as? Pickaxe
            ToolIntent.Axe -> event.itemInHand.toRpgItem() as? Axe
            ToolIntent.Hoe -> event.itemInHand.toRpgItem() as? Hoe
        }
        val speed = ((when (data.intent) {
            ToolIntent.Pickaxe -> (tool as? Pickaxe)?.speed
            ToolIntent.Axe -> (tool as? Axe)?.speed
            else -> null
        }?.times(10) ?: 0) + 100) / 100.0f
        val power = when (data.intent) {
            ToolIntent.Pickaxe -> (tool as? Pickaxe)?.power
            ToolIntent.Axe -> (tool as? Axe)?.power
            else -> null
        }
        if (power != null && data.strength > power) return
        if (data.intent != ToolIntent.Any && data.intent != ToolIntent.Hoe && tool == null) return
        if (data.duration == Duration.ZERO) {
            breakBlock(event.player, event.block, tool); return
        }
        jobs[event.player.uniqueId] = PluginScope.launch {
            try {
                for (i in -1..9) {
                    distributeBlockProgress(event.player, event.block, i)
                    delay((data.duration.inWholeMilliseconds / (8 * speed)).toLong())
                }
                PluginScope.sync {
                    breakBlock(event.player, event.block, tool)
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
    
    
    private fun breakBlock(player: Player, block: Block, tool: Item?) {
        when (block.type) {
            in DefaultRegenQueue.handled -> DefaultRegenQueue.queue(block)
            in StoneRegenQueue.handled -> StoneRegenQueue.queue(block)
            else -> { /* Ignore */
            }
        }
        val blockParticlePacket = PacketPlayOutWorldEvent(
            2001,
            block.run { BlockPosition(x, y, z) },
            net.minecraft.world.level.block.Block.i((block as CraftBlock).nms),
            false
        )
        block.world.getNearbyEntities(block.location, 32.0, 32.0, 32.0) {
            if (block.rpgData!!.duration == Duration.ZERO) it is Player && it != player else it is Player // Prevent instabreak double particles
        }.forEach {
            (it as CraftPlayer).handle.b.a(blockParticlePacket)
        }
        block.rpgData!!.drops.next(tool).forEach {
            block.world.dropItemNaturally(block.location, it.toItemStack())
        }
        block.type = Material.AIR
    }
    
    @EventHandler
    fun onBlockDamageAbort(event: BlockDamageAbortEvent) {
        jobs[event.player.uniqueId]?.cancel()
    }
    
}