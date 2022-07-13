package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Tool

object TheHoeOfAllHoes : Tool {
    
    override val id: String = "the_hoe_of_all_hoes"
    override val texId: Int = 2
    override val name: String = "The Hoe of All Hoes"
    override val rarity: Rarity = Rarity.Divine
    override val description: String? = null
    override val details: List<String> = listOf("1000% increased farming drops.")
    
}