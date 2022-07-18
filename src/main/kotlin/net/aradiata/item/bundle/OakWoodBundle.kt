package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.Tool
import net.aradiata.item.type.OakWood

object OakWoodBundle : Bundle {
    
    override fun chanceIncrease(tool: Tool): Int = tool.dropIncrease
    
    override fun next(tool: Tool): List<Item> = buildList {
        chance(25.0, tool) { add(OakWood) }
    }
    
}