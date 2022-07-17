package net.aradiata.item.type

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Wheat : Resource {
    
    override val configId: String = "wheat"
    override val id: Int = 5
    override val name: String = "Wheat"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}