package net.aradiata.item.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item

object EmptyBundle : Bundle {
    
    override fun next(tool: Item?): List<Item> = emptyList()
    
}