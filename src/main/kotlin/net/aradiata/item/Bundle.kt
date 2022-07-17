package net.aradiata.item

import kotlin.random.Random

interface Bundle {
    
    fun next(tool: Tool): List<Item>
    
    fun chanceIncrease(tool: Tool): Int = 0
    
    fun chance(chance: Double, tool: Tool, block: () -> Unit) {
        val total = (chanceIncrease(tool).toDouble() / 100 + 1) * chance
        repeat((total / 100).toInt()) {
            block()
        }
        if (Random.nextDouble(0.0, 100.0) < total % 100.0) {
            block()
        }
    }
    
}