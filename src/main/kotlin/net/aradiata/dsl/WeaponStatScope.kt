package net.aradiata.dsl

fun WeaponScope.stats(configuration: WeaponStatScope.() -> Unit): Unit =
    stats.configuration()

class WeaponStatScope {
    
    val stats: MutableList<WeaponStat> = mutableListOf()
    
    fun stat(type: WeaponStatType, value: Double, chance: Double = 100.0) {
        stats.add(WeaponStat(type, value, chance))
    }
    
}

enum class WeaponStatType {
    
    DamageMelee,
    DamageRanged,
    DamageMagic;
    
}

data class WeaponStat(val type: WeaponStatType, val value: Double, val chance: Double = 100.0)