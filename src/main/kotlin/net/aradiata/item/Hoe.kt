package net.aradiata.item

import net.aradiata.plugin.colored

interface Hoe : Item {
    
    val dropIncrease: Int
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.add("&fDrop Chance: &${rarity.colorCode}+$dropIncrease%".colored())
    }
    
}