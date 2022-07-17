package net.aradiata.item

import net.aradiata.plugin.colored

interface Axe : Item {
    
    val power: Int
    val speed: Int
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.add("&fAxe Power: &${rarity.colorCode}+$power".colored())
        val speedDisplay: String = when {
            speed > 120 -> "Insanely Fast"
            speed > 100 -> "Very Fast"
            speed > 80 -> "Fast"
            speed > 60 -> "Average"
            speed > 40 -> "Slow"
            speed > 20 -> "Very Slow"
            else -> "Extremely Slow"
        }
        lore.add("&fSpeed: &${rarity.colorCode}$speedDisplay".colored())
    }
    
}