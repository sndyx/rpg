package net.aradiata.item

class Resource(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String?
) : Item {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}