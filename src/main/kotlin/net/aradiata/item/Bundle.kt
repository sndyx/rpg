package net.aradiata.item

import kotlin.random.Random

interface Bundle {

    fun determineItemWeight(item: Item?): Double = 0.0
    
    fun next(tool: Item?): List<Item>

    fun next(tool: Item?, n: Int): List<Item> = List(n) { next(tool) }.flatten()

    fun chance(chance: Double, item: Item?, block: () -> Unit) {
        val total = determineItemWeight(item) + chance
        repeat((total / 100).toInt()) {
            block()
        }
        if (Random.nextDouble(0.0, 100.0) < total % 100.0) {
            block()
        }
    }
    
}