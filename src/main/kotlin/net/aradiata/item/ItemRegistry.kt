package net.aradiata.item

import net.aradiata.item.impl.crystal_boots
import net.aradiata.item.impl.crystal_chestplate
import net.aradiata.item.impl.crystal_helmet
import net.aradiata.item.impl.crystal_leggings

object ItemRegistry : MutableList<Item> by mutableListOf()

fun loadItems() {
    ItemRegistry.addAll(listOf(
        crystal_helmet(),
        crystal_chestplate(),
        crystal_leggings(),
        crystal_boots()
    ))
}