package net.aradiata.item

import net.aradiata.item.impl.lightningTyphoon

object ItemRegistry : MutableList<Item> by mutableListOf()

fun loadItems() {
    val items = listOf<Item>(
        lightningTyphoon
    )
    items.forEach {
        ItemRegistry.add(it)
    }
}