package net.aradiata.item

abstract class Item(
    val id: String,
    val model: Int,
    val name: String,
    val rarity: Rarity,
    val description: String?,
    val events: ItemEvents
) {
    
    abstract fun writeDetails(lore: MutableList<String>)
    
}