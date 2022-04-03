package net.aradiata.item

import net.aradiata.item.type.ItemRequirements
import net.aradiata.item.type.RequirementHolder
import net.aradiata.utility.colored

class Weapon(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String?,
    override val requirements: ItemRequirements,
    private val stats: List<WeaponStat>
) : Item, RequirementHolder {
    
    override fun writeDetails(lore: MutableList<String>) { // Don't ask lmao
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