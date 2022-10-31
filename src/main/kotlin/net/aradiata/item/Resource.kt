package net.aradiata.item

class Resource(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents
) : Item(id, model, name, rarity, description, events) {
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}