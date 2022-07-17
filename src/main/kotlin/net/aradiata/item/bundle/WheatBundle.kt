package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Hoe
import net.aradiata.item.Item
import net.aradiata.item.type.Wheat

object WheatBundle : Bundle {
    
    override fun chanceIncrease(item: Item?): Int = (item as? Hoe)?.dropIncrease ?: 0
    
    override fun next(tool: Item?): List<Item> = buildList {
        chance(100.0, tool) { add(Wheat) }
    }
    
}