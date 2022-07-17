package net.aradiata.item.type

import net.aradiata.item.Pickaxe
import net.aradiata.item.Rarity

object StonePickaxe : Pickaxe {

    override val configId: String = "stone_pickaxe"
    override val id: Int = 8
    override val name: String = "Stone Pickaxe"
    override val rarity: Rarity = Rarity.Uncommon
    override val description: String? = "STONE STONE STONE"

    override val power: Int = 20
    override val speed: Int = 50
    override val dropIncrease: Int = 690

}