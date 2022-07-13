package net.aradiata.item.impl

import net.aradiata.item.Rarity
import net.aradiata.item.Tool

object WoodenHoe : Tool {
    
    override val configId: String = "wooden_hoe"
    override val id: Int = 9
    override val name: String = "Wooden Hoe"
    override val rarity: Rarity = Rarity.Common
    override val description: String = "A sturdy wooden hoe."
    override val details: List<String> = listOf("10% increased farming drops.")
    
}