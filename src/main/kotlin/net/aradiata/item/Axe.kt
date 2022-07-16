package net.aradiata.item

import net.aradiata.plugin.colored

interface Axe : Item {
    
    val power: Int
    val speed: Int
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.add("&fAxe Power: &${rarity.colorCode}+$power".colored())
        lore.add("&fSpeed: &${rarity.colorCode}+$speed%".colored())
    }
    
}