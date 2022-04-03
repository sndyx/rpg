package net.aradiata.item.type

import net.aradiata.item.Item
import net.aradiata.item.Rarity

class Weapon(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String? = null,
    override val requirements: ItemRequirements,
    val weaponStats: WeaponStats
) : Item, RequirementHolder {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}

class WeaponStats {
    
}

enum class WeaponStatType {



}