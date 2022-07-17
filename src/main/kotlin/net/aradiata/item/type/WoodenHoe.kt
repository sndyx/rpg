package net.aradiata.item.type

import net.aradiata.item.Hoe
import net.aradiata.item.Rarity

object WoodenHoe : Hoe {
    
    override val configId: String = "wooden_hoe"
    override val id: Int = 3
    override val name: String = "Wooden Hoe"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
    override val dropIncrease: Int = 20
    
}