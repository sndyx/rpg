package net.aradiata.dsl

import net.aradiata.item.Item
import kotlin.io.path.Path
import kotlin.io.path.name

fun loadAllItems(): Map<String, Item> {
    
    val map = mutableMapOf<String, Item>()
    
    Path("rpg/items").forEach {
        println("Loading item `${it.name}`.")
        
        val result = when (val type = it.name.split(".")[1]) {
            "resource" -> {
                runResourceScript(it)
            }
            "weapon" -> {
                runWeaponScript(it)
            }
            else -> error("Invalid item type: $type")
        }
        
        result.onFailure { ex ->
            println("Error loading `${it.name}`!")
            ex.printStackTrace()
        }
        
        result.onSuccess { item ->
            map[item.id] = item
        }
    }
    
    return map
    
}