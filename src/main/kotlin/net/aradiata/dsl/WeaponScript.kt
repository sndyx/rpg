package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Weapon
import net.aradiata.item.WeaponStat
import net.aradiata.item.WeaponStatType
import kotlin.script.experimental.annotations.KotlinScript

@Delegate(WeaponDelegate::class)
@KotlinScript(fileExtension = "weapon.kts")
abstract class WeaponScript

class WeaponDelegate : RequirementItemDelegate() {
    
    private val weaponStats = WeaponStatsScope()
    
    override fun toItem(): Item {
        
        return Weapon(
            id!!,
            name!!,
            rarity!!,
            description,
            requirements.build(),
            weaponStats.build(),
            weaponStats.suppressMeleeDamage
        )
    }
    
    fun stats(block: WeaponStatsScope.() -> Unit) {
        weaponStats.block()
    }

}

class WeaponStatsScope {

    var suppressMeleeDamage: Boolean = true
    private val stats = mutableListOf<WeaponStatDelegate>()
    
    fun build(): List<WeaponStat> {
        return stats.map {
            WeaponStat(
                WeaponStatType.values()[it.type.ordinal],
                it.value,
                it.chance
            )
        }
    }
    
    fun suppressMeleeDamage() {
        suppressMeleeDamage = true
    }
    
    fun magic(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Magic, value)
        stats.add(stat)
        return stat
    }
    
    fun ranged(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Ranged, value)
        stats.add(stat)
        return stat
    }
    fun melee(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Melee, value)
        stats.add(stat)
        return stat
    }
    
    fun attackSpeed(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.AttackSpeed, value)
        stats.add(stat)
        return stat
    }

}

class WeaponStatDelegate(val type: WeaponStatTypeDelegate, val value: Double) {
    
    var chance: Double = 100.0
    
    infix fun chance(value: Double) {
        chance = value
    }
    
}

enum class WeaponStatTypeDelegate {
    
    Melee,
    Magic,
    Ranged,
    AttackSpeed;
    
}