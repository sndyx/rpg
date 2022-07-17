package net.aradiata.item.type

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Fiber : Resource {
    
    override val configId: String = "plant_fiber"
    override val id: Int = 4
    override val name: String = "Plant Fiber"
    override val rarity: Rarity = Rarity.Common
    override val description: String = "A fairly durable natural fiber. Could be useful for makeshift tools."
    
}