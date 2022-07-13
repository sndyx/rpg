package net.aradiata.item.impl

import net.aradiata.item.*
import net.aradiata.utility.colored

object PinkSpell : Weapon {
    
    override val id: String = "pink_spell"
    override val texId: Int = 2
    override val name: String = "Pink Spell"
    override val rarity: Rarity = Rarity.Divine
    override val description: String = "The most powerful spell in the &dworld.".colored()
    
    override val stats: List<WeaponStat> = stats {
        magic(1000.0)
        melee(1000.0)
        ranged(1000.0)
    }
    override val suppressMeleeDamage: Boolean = false
    
}