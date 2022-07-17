package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.Tool
import net.aradiata.item.type.Wheat

object WheatBundle : Bundle {
    
    override fun chanceIncrease(tool: Tool): Int = tool.dropIncrease
    
    override fun next(tool: Tool): List<Item> = buildList {
        chance(100.0, tool) { add(Wheat) }
    }
    
}