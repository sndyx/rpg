package net.aradiata.item

class Hoe(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents,
    val harvest: Int
) : Tool(
    id, model, name, rarity, description, events
) {
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.add("§fHarvest: §${rarity.colorCode}+$harvest%")
    }
    
}