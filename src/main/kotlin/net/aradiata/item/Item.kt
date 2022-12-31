package net.aradiata.item

import org.bukkit.Material

abstract class Item(
    val id: String,
    val model: Int,
    val name: String,
    val rarity: Rarity,
    val description: String?,
    val events: ItemEvents
) {
    
    abstract val material: Material
    
    abstract fun writeDetails(lore: MutableList<String>)
    
}