package net.aradiata.item.impl

import kotlinx.coroutines.delay
import net.aradiata.Plugin
import net.aradiata.item.*
import net.aradiata.item.dsl.*
import net.aradiata.player.damageTo
import net.aradiata.player.handle
import net.aradiata.plugin.sync
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.LivingEntity
import kotlin.math.*
import kotlin.random.Random

val lightningTyphoon = weapon("lightning_typhoon") {
    
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
                                val damage = player.damageTo(it)
                                it.damage(damage)
                            }
                        }
                        delay(100)
                    }
                }
            }
        }
        
    }
    
}