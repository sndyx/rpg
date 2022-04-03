package net.aradiata.item.type

import net.aradiata.item.Item
import net.aradiata.item.Rarity

class Resource(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String? = null,
) : Item {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }

}