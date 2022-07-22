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
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.time.Duration

object BlockEventListener : Listener {
    
    private val jobs = mutableMapOf<UUID, Job>()

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.player.addPotionEffect(PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, -1, false, false))
    }
    
    @EventHandler
    fun onBlockDamage(event: BlockDamageEvent) {
        event.isCancelled = true
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
            breakTree(player, block, tool)
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
    
    private fun breakTree(player: Player, block: Block, tool: Tool) {
        val wood = findWood(block)
        PluginScope.launch {
            wood.groupBy { it.y }.toSortedMap().forEach { group ->
                PluginScope.sync {
                    group.value.forEach {
                        DefaultRegenQueue.queue(it)
                        distributeBlockBreak(player, it)
                        it.rpgData!!.drops.next(tool).forEach { item ->
                            it.world.dropItemNaturally(it.location, item.toItemStack())
                        }
                        it.type = Material.AIR
                    }
                }
                delay(20)
            }
            val leaves = findLeaves(wood)
            leaves.forEach {
                PluginScope.sync {
                    DefaultRegenQueue.queue(it)
                    it.rpgData!!.drops.next(tool).forEach { item ->
                        it.world.dropItemNaturally(it.location, item.toItemStack())
                    }
                    it.type = Material.AIR
                }
                delay((1000 / leaves.size).toLong())
            }
        }
    }
    
    private fun findWood(block: Block): Set<Block> {
        val wood = mutableSetOf(block)
        val blocks = ArrayDeque<Block>()
        
        // ensure cut base
        for (x in -1..1) {
            for (z in -1..1) {
                if (x == 0 && z == 0) continue
                val relative = block.getRelative(x, 0, z)
                if (relative.isWood()) return wood
            }
        }
        
        // find vertical neighbors
        for (x in -1..1) {
            for (z in -1..1) {
                val relative = block.getRelative(x, 1, z)
                if (relative.isWood()) blocks.add(relative)
            }
        }
        
        // follow path
        while (blocks.isNotEmpty()) {
            val current = blocks.removeFirst()
            for (x in -1..1) {
                for (y in -1..1) {
                    for (z in -1..1) {
                        val relative = current.getRelative(x, y, z)
                        if (relative.isWood() && !wood.contains(relative)) {
                            blocks.add(relative)
                            wood.add(relative)
                        }
                    }
                }
            }
        }
        
        return wood
    }
    
    private fun findLeaves(wood: Set<Block>): Set<Block> {
        val leaves = mutableSetOf<Block>()
        val blocks = ArrayDeque<Block>().apply { addAll(wood) }
        
        while (blocks.isNotEmpty()) {
            val current = blocks.removeFirst()
            for (x in -1..1) {
                for (y in -1..1) {
                    for (z in -1..1) {
                        val relative = current.getRelative(x, y, z)
                        if (relative.isLeaves() && !leaves.contains(relative) && !relative.isNextToWood()) {
                            blocks.add(relative)
                            leaves.add(relative)
                        }
                    }
                }
            }
        }
        
        return leaves
    }
    
    private fun Block.isNextToWood(): Boolean {
        for (x in -1..1) {
            for (y in -1..1) {
                for (z in -1..1) {
                    val relative = getRelative(x, y, z)
                    if (relative.isWood()) return true
                }
            }
        }
        return false
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