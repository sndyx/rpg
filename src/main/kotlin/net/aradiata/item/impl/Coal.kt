package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Coal : Resource {
    
    override val configId: String = "coal"
    override val id: Int = 1
    override val name: String = "Coal"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}