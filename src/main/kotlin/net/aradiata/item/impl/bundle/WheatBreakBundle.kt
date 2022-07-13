package net.aradiata.item.impl.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.impl.Wheat
import net.aradiata.item.impl.WoodenHoe
import net.aradiata.item.impl.farmingItemWeight
import kotlin.random.Random

object WheatBreakBundle : Bundle {
    
    override fun determineItemWeight(item: Item?): Double = farmingItemWeight(item)
    
    override fun next(tool: Item?): List<Item> = buildList {
        chance(100.0, tool) { add(Wheat) }
    }
    
}