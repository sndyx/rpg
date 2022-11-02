package net.aradiata.item

class Pickaxe(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents,
    val speed: Int,
    val power: Int
) : Tool(
    id, model, name, rarity, description, events
) {
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.add("§fSpeed: §${rarity.colorCode}+$speed")
        lore.add("§fPickaxe Power: §${rarity.colorCode}+$power")
    }
    
}