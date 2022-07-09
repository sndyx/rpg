package net.aradiata.item

import net.aradiata.utility.colored
import org.bukkit.Material

interface Weapon : Item {

    val stats: List<WeaponStat>
    val suppressMeleeDamage: Boolean

    override val material: Material
        get() = Material.NETHERITE_SWORD

    override fun writeDetails(lore: MutableList<String>) {
        stats.sortedWith(compareBy<WeaponStat> { it.type.ordinal }.thenBy { it.chance }.thenBy { it.value }).apply {
            filter { it.type.isPrimary }.forEach {
                lore.add("&f${it.type.displayName}: &${rarity.colorCode}+${it.value} ${if (it.chance != 100.0) "&8(${it.chance}%)" else ""}".colored())
            }
            filterNot { it.type.isPrimary }.also { if (it.isNotEmpty()) lore.add("") }.forEach {
                lore.add("&f${it.type.displayName}: &${rarity.colorCode}+${it.value} ${if (it.chance != 100.0) "&8(${it.chance}%)" else ""}".colored())
            }
        }
    }

}

class WeaponStat(val type: WeaponStatType, val value: Double, val chance: Double)

enum class WeaponStatType(val isPrimary: Boolean, val displayName: String) {

    Melee(true, "Melee Damage"),
    Magic(true, "Magic Damage"),
    Ranged(true, "Ranged Damage"),

    AttackSpeed(false, "Attack Speed");

}

fun stats(builder: MutableList<WeaponStat>.() -> Unit): List<WeaponStat> {
    return buildList {
        builder()
    }
}

fun MutableList<WeaponStat>.melee(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Melee, value, chance))
fun MutableList<WeaponStat>.magic(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Magic, value, chance))
fun MutableList<WeaponStat>.ranged(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Ranged, value, chance))
fun MutableList<WeaponStat>.speed(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.AttackSpeed, value, chance))