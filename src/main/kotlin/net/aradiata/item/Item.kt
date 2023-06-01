package net.aradiata.item

import org.bukkit.Material
import org.bukkit.entity.Player

interface Item {

    val id: String
    val model: Int
    val material: Material
    val rarity: Rarity
    val description: String?

    fun lore(): List<String>

    fun onEquip() { /* Ignore */ }
    fun onUnequip() { /* Ignore */ }
    fun onLeftClick(player: Player) { /* Ignore */ }
    fun onRightClick(player: Player) { /* Ignore */ }

}