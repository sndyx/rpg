package net.aradiata.item.impl

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.aradiata.Plugin
import net.aradiata.item.*
import net.aradiata.item.dsl.*
import net.aradiata.plugin.sync
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.LivingEntity
import kotlin.math.*
import kotlin.random.Random

val armor = armor("id") {
    
    model = 1
    name = "Test Helmet"
    rarity = Rarity.Common // Uncommon, Rare, Epic, Legendary, Divine
    // description = ""
    type = ArmorType.Helmet // Chestplate, Leggings, Boots
    
    stats {
        melee(10.0) // %
        magic(10.0) // %
        ranged(10.0) // %
        
        health(10.0) // +
        defense(10.0) // +
        mana(10.0) // +
        speed(10.0) // %
        attackSpeed(10.0) // %
    }
    
}

val lightningTyphoon = weapon("lightning-typhoon") {
    
    model = 1
    name = "Lightning Typhoon"
    rarity = Rarity.Legendary
    description = "And I will strike down upon thee with GREAT vengeance and FURIOUS anger."
    
    suppressMeleeDamage()
    stats {
        magic(95.0)
    }
    
    events {
        
        onRightClick { player ->
            player.rayTraceBlocks(30.0)?.hitBlock?.let {
                ability(15, player) {
                    val loc = it.location.add(0.0, 1.0, 0.0)
                    repeat(20) { offset ->
                        repeat(5) {
                            val angle = 2 * PI * it / 5.0 + (offset / 5.0)
                            val point = loc.clone().add((7.0 - offset / 5.0) * sin(angle), 0.5, (7.0 - offset / 5.0) * cos(angle))
                            player.world.spawnParticle(Particle.FIREWORKS_SPARK, point.x, point.y, point.z, 3, 0.0, 0.0, 0.0, 0.05)
                        }
                        delay(50)
                    }
                    repeat(3) { _ ->
                        repeat(10) { _ ->
                            val r = 7.0 * sqrt(Random.nextDouble())
                            val theta = Random.nextDouble() * 2 * PI
                            val x = it.x + r * cos(theta)
                            val z = it.z + r * sin(theta)
                            val pos = Location(it.world, x, it.y.toDouble(), z)
                            Plugin.sync {
                                player.world.strikeLightningEffect(pos)
                            }
                        }
                        Plugin.sync {
                            val targets = player.world.getNearbyEntities(
                                it.location, 5.0, 5.0, 5.0
                            ).filterIsInstance<LivingEntity>().filterNot { it == player }
                            targets.forEach {
                                it.damage(5.0)
                            }
                        }
                        delay(100)
                    }
                }
            }
        }
        
    }
    
}