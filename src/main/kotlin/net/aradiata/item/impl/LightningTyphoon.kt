package net.aradiata.item.impl

import net.aradiata.item.*

object LightningTyphoon : Weapon {

    override val configId: String = "lightning_typhoon"
    override val id: Int = 4
    override val name: String = "Lightning Typhoon"
    override val rarity: Rarity = Rarity.Legendary
    override val description: String? = null

    override val stats: List<WeaponStat> = stats {
        magic(10.0)
    }
    override val suppressMeleeDamage: Boolean = true

}