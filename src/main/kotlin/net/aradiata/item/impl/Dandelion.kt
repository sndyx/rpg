package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Dandelion : Resource {
    
    override val configId: String = "dandelion"
    override val id: Int = 2
    override val name: String = "Dandelion"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null
    
}