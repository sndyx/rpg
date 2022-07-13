package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Wheat : Resource {
    
    override val configId: String = "wheat"
    override val id: Int = 8
    override val name: String = "Wheat"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}