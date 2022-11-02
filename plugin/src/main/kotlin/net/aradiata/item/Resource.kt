package net.aradiata.item

import org.bukkit.Material

class Resource(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents
) : Item(id, model, name, rarity, description, events) {
    
    override val material: Material = Material.STICK
    
    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }
    
}