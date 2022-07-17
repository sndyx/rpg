package net.aradiata.item.type

import net.aradiata.item.Axe
import net.aradiata.item.Rarity

object WoodenAxe : Axe {
    
    override val configId: String = "wooden_axe"
    override val id: Int = 2
    override val name: String = "Wooden Axe"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
    override val power: Int = 10
    override val speed: Int = 40
    
}