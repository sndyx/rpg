package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.Tool

object EmptyBundle : Bundle {
    
    override fun next(tool: Tool): List<Item> = emptyList()
    
}