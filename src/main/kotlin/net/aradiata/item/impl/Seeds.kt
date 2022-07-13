package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Seeds : Resource {

    override val configId: String = "wheat_seeds"
    override val id: Int = 6
    override val name: String = "Wheat Seeds"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null

}