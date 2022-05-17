package net.aradiata.item

import java.io.Serializable

class Resource(
    override val id: String,
    override val texId: Int,
    override val name: String,
    override val rarity: Rarity,
    override val description: String?
) : Item, Serializable {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}