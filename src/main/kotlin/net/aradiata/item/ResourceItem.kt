package net.aradiata.item

class ResourceItem(
    override val id: String,
    override val name: String,
    override val rarity: Rarity,
    override val description: String? = null,
    override val eventHandler: ItemEventHandler
) : Item {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }

}