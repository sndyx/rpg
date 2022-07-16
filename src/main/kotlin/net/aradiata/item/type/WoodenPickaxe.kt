package net.aradiata.item.type

import net.aradiata.item.Pickaxe
import net.aradiata.item.Rarity

object WoodenPickaxe : Pickaxe {
    
    override val configId: String = "wooden_pickaxe"
    override val id: Int = 0
    override val name: String = "Wooden Pickaxe"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
    override val power: Int = 10
    override val speed: Int = 40
    
}