package net.aradiata.player

import net.aradiata.Plugin
import net.aradiata.item.*
import net.aradiata.plugin.schedule
import net.aradiata.plugin.ticks
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import kotlin.math.min

fun PlayerHandle.updateArmor() {
    state.apply {
        Plugin.schedule(1.ticks) { // delay to let any events pass
            maxHealth = 20.0
            maxMana = 20.0
            defense = 0.0
        
            val armor = player.inventory.armorContents
                .map { it?.toItem() as? Armor }
                .filterNotNull()
        
            armor.forEach { piece ->
                piece.stats.forEach { stat ->
                    when (stat.type) {
                        ArmorStatType.Melee -> { increaseMelee += stat.value }
                        ArmorStatType.Magic -> { increaseMagic += stat.value }
                        ArmorStatType.Ranged -> { increaseRanged += stat.value }
                        ArmorStatType.Mana -> { maxMana += stat.value.toInt() }
                        ArmorStatType.Health -> { maxHealth += stat.value.toInt() }
                        ArmorStatType.Defense -> { defense += stat.value }
                        else -> { /* Ignore */ }
                    }
                }
            }
        
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = maxHealth
            player.getAttribute(Attribute.GENERIC_ARMOR)?.baseValue = 20.0 - reduceDamage(20.0, defense)
        }
    }
}

fun PlayerHandle.updateWeapon() {
    val weapon = player.inventory.itemInMainHand
        .toItem()
        ?.takeIf { it is Weapon } as? Weapon
    state.damage = weapon?.let { damageOf(it) } ?: 1.0
    state.ignoreMelee = weapon?.ignoreMelee ?: false
}

fun PlayerHandle.damageOf(weapon: Weapon): Double {
    val weaponStats = weapon.stats.map {
        when (it.type) {
            WeaponStatType.Melee -> { it.value * (1.0 + state.increaseMelee) }
            WeaponStatType.Magic -> { it.value * (1.0 + state.increaseMagic) }
            WeaponStatType.Ranged -> { it.value * (1.0 + state.increaseRanged) }
            else -> 0.0
        }
    }
    return 1.0 + weaponStats.sum()
}

fun LivingEntity.damageTo(other: LivingEntity, weapon: Weapon? = null, melee: Boolean = true): Double {
    if (this is Player) {
        handle().apply {
            if (state.weaponFlag) {
                updateWeapon()
                state.weaponFlag = false
            }
            val ignoreMelee = weapon?.ignoreMelee ?: state.ignoreMelee
            if (melee && ignoreMelee) return 1.0 // SCREW U!!!!
            val damage = weapon?.let { damageOf(it) } ?: state.damage
            return if (other is Player) {
                reduceDamage(damage, other.handle().state.defense)
            } else {
                damage
            }
        }
    } else return 1.0 // TODONT
}

fun reduceDamage(damage: Double, defense: Double): Double {
    return damage * (1 - defense / (defense + 20))
}