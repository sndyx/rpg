package net.aradiata.item.impl

import net.aradiata.item.Item

fun farmingItemWeight(item: Item?): Double = when (item) {
    WoodenHoe -> 10.0
    TheHoeOfAllHoes -> 1000.0
    else -> 0.0
}