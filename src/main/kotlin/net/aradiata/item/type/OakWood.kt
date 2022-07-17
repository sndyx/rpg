package net.aradiata.item.type

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object OakWood : Resource {
    
    override val configId: String = "oak_wood"
    override val id: Int = 7
    override val name: String = "Oak Wood"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}