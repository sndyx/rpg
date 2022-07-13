package net.aradiata.bundles.item

import net.aradiata.item.Item
import net.aradiata.item.impl.Wheat
import net.aradiata.item.impl.farmingItemWeight

object WheatBreakBundle : ItemBundle {
    
    override fun determineItemWeight(item: Item?): Double = farmingItemWeight(item)
    
    override fun next(tool: Item?): List<Item> = buildList {
        chance(100.0, tool) { add(Wheat) }
    }
    
}