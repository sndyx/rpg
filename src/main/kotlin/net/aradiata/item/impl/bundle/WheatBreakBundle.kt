package net.aradiata.item.impl.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.impl.Wheat
import kotlin.random.Random

object WheatBreakBundle : Bundle {
    
    override fun next(): List<Item> = buildList {
        add(Wheat)
        if (Random.nextInt(1, 5) == 1) add(Wheat)
    }
    
}