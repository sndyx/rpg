package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Dandelion : Resource {
    
    override val id: String = "dandelion"
    override val texId: Int = 3
    override val name: String = "Dandelion"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}