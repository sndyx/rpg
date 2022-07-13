package net.aradiata.item

import net.aradiata.utility.colored

interface Tool : Item {
    
    val details: List<String>
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.addAll(details.map { "&f$it".colored() })
    }
    
}