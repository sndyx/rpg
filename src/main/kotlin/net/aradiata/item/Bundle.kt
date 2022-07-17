package net.aradiata.item

import kotlin.random.Random

interface Bundle {
    
    fun next(tool: Item?): List<Item>
    
    fun chanceIncrease(item: Item?): Int = 0
    
    fun chance(chance: Double, item: Item?, block: () -> Unit) {
        val total = (chanceIncrease(item).toDouble() / 100 + 1) * chance
        repeat((total / 100).toInt()) {
            block()
        }
        if (Random.nextDouble(0.0, 100.0) < total % 100.0) {
            block()
        }
    }
    
}