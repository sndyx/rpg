package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Coal : Resource {
    
    override val id: String = "coal"
    override val texId: Int = 5
    override val name: String = "Coal"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}