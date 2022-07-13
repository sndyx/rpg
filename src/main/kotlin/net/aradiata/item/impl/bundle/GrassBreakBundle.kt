package net.aradiata.item.impl.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.impl.Fiber
import net.aradiata.item.impl.Seeds
import net.aradiata.item.impl.WoodenHoe
import net.aradiata.item.impl.farmingItemWeight
import kotlin.random.Random

object GrassBreakBundle : Bundle {
    
    override fun determineItemWeight(item: Item?): Double = farmingItemWeight(item)
    
    override fun next(tool: Item?): List<Item> = buildList {
        chance(15.0, tool) { add(Seeds) }
        chance(10.0, tool) { add(Fiber) }
    }

}