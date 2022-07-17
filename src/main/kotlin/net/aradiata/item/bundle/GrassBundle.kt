package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Hoe
import net.aradiata.item.Item
import net.aradiata.item.type.Fiber

object GrassBundle : Bundle {
    
    override fun chanceIncrease(item: Item?): Int = (item as? Hoe)?.dropIncrease ?: 0
    
    override fun next(tool: Item?): List<Item> = buildList {
        chance(8.0, tool) { add(Fiber) }
    }
    
}