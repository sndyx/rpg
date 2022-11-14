package net.aradiata.item

import net.aradiata.item.impl.lightningTyphoon
import net.aradiata.item.impl.theChestplateOfSomewhatGreatness
import net.aradiata.item.impl.theHelmetOfGreatness

object ItemRegistry : MutableList<Item> by mutableListOf()

fun loadItems() {
    val items = listOf(
        lightningTyphoon,
        theHelmetOfGreatness,
        theChestplateOfSomewhatGreatness
    )
    items.forEach {
        ItemRegistry.add(it)
    }
}