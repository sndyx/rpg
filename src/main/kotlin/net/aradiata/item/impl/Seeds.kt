package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Resource

object Seeds : Resource {

    override val id: String = "wheat-seeds"
    override val texId: Int = 0
    override val name: String = "Wheat Seeds"
    override val rarity: Rarity = Rarity.Common
    override val description: String? = null

}