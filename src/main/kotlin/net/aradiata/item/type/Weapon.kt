package net.aradiata.item.type

import net.aradiata.item.ItemEventHandler
import net.aradiata.item.Rarity

class Weapon(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String? = null,
    override val eventHandler: ItemEventHandler,
    override val requirements: ItemRequirements,
    override val
) : RequirementItem {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}

class WeaponStatBoost()