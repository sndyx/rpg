package net.aradiata.block

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.aradiata.PluginScope
import net.aradiata.block.BlockData.Companion.rpgData
import net.aradiata.block.queue.DefaultRegenQueue
import net.aradiata.block.queue.StoneRegenQueue
import net.aradiata.item.*
import net.aradiata.item.Item.Companion.toRpgItem
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

        val tool: Tool = (when (data.intent) {
            ToolIntent.Any -> event.itemInHand.toRpgItem() as? Tool
            ToolIntent.Pickaxe -> event.itemInHand.toRpgItem() as? Pickaxe
            ToolIntent.Axe -> event.itemInHand.toRpgItem() as? Axe
            ToolIntent.Hoe -> event.itemInHand.toRpgItem() as? Hoe
        } ?: Fist)

        val speed = (tool.speed.times(10) + 100) / 100.0f
        val power = tool.power

        if (data.strength > power) return
        if (data.duration == Duration.ZERO) {
            breakBlock(event.player, event.block, tool)
            return
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

    // Prevent instabreak double particles as well
    private fun distributeBlockBreak(player: Player, block: Block) {
        val blockParticlePacket = PacketPlayOutWorldEvent(
            2001,
            block.run { BlockPosition(x, y, z) },
            net.minecraft.world.level.block.Block.i((block as CraftBlock).nms),
            false
        )
        block.world.getNearbyEntities(block.location, 32.0, 32.0, 32.0) {
            it is Player
        }.forEach {
            if (block.rpgData!!.duration != Duration.ZERO || it != player) {
                (it as CraftPlayer).handle.b.a(blockParticlePacket)
            }
        }
    }
    
    private fun breakBlock(player: Player, block: Block, tool: Tool) {
        if (block.isWood()) {
            breakTree(player, block, tool, true)
            return
        }
        
        when (block.type) {
            in DefaultRegenQueue.handled -> DefaultRegenQueue.queue(block)
            in StoneRegenQueue.handled -> StoneRegenQueue.queue(block)
            else -> { /* Ignore */ }
        }

        distributeBlockBreak(player, block)

        block.rpgData!!.drops.next(tool).forEach {
            block.world.dropItemNaturally(block.location, it.toItemStack())
        }
        block.type = Material.AIR
    }
    
    private fun breakTree(player: Player, block: Block, tool: Tool, isRoot: Boolean) {
        val neighbors = buildList<Block> {
            for (x in -1..1) {
                for (z in -1..1) {
                    for (y in 0..1) {
                        if (x == 0 && z == 0 && y == 0) continue
                        block.getRelative(x, y, z)
                    }
                }
            }
        }
        neighbors.forEach {
            if (it.isWood()) {
                breakTree(player, block, tool, false)
            }
        }
        DefaultRegenQueue.queue(block)
        if (isRoot) distributeBlockBreak(player, block)
        block.rpgData!!.drops.next(tool).forEach { item ->
            block.world.dropItemNaturally(block.location, item.toItemStack())
        }
        block.type = Material.AIR
        neighbors.forEach {
            breakLeaves(it, tool)
        }
    }
    
    private fun breakLeaves(block: Block, tool: Tool) {
        val neighbors = buildList<Block> {
            for (x in -1..1) {
                for (z in -1..1) {
                    for (y in -1..1) {
                        if (x == 0 && z == 0 && y == 0) continue
                        block.getRelative(x, y, z)
                    }
                }
            }
        }
        if (neighbors.none { it.isWood() }) {
            if (block.type != Material.AIR) {
                DefaultRegenQueue.queue(block)
                block.rpgData!!.drops.next(tool).forEach { item ->
                    block.world.dropItemNaturally(block.location, item.toItemStack())
                }
                block.type = Material.AIR
            }
            neighbors.forEach {
                if (it.isLeaves()) {
                    breakLeaves(it, tool)
                }
            }
        }
    }
    
    private fun Block.isWood(): Boolean {
        return when (type) {
            Material.OAK_WOOD, Material.BIRCH_WOOD, Material.DARK_OAK_WOOD, Material.ACACIA_WOOD, Material.MANGROVE_WOOD, Material.SPRUCE_WOOD, Material.JUNGLE_WOOD -> true
            else -> false
        }
    }
    
    private fun Block.isLeaves(): Boolean {
        return when (type) {
            Material.OAK_LEAVES, Material.BIRCH_LEAVES, Material.DARK_OAK_LEAVES, Material.ACACIA_LEAVES, Material.MANGROVE_LEAVES, Material.SPRUCE_LEAVES, Material.JUNGLE_LEAVES, Material.AZALEA_LEAVES, Material.FLOWERING_AZALEA_LEAVES -> true
            else -> false
        }
    }
    
    @EventHandler
    fun onBlockDamageAbort(event: BlockDamageAbortEvent) {
        jobs[event.player.uniqueId]?.cancel()
    }
    
}