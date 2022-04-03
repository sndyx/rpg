package net.aradiata.dsl

import net.aradiata.item.Item
import kotlin.io.path.Path
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name

fun loadAllItems(): Map<String, Item> {
    
    val map = mutableMapOf<String, Item>()
    
    Path("rpg/items").listDirectoryEntries().forEach {
        
        println("Loading item `${it.name}`.")
        
        val result = when (val type = it.name.split(".")[1]) {
            "resource" -> {
                runScript<ResourceScript>(it)
            }
            "weapon" -> {
                runScript<WeaponScript>(it)
            }
            else -> error("Invalid item type: $type")
        }
        
        result.onFailure { _ ->
            println("Error loading `${it.name}`!")
        }
        
        result.onSuccess { item ->
            map[item.id] = item
        }
    }
    
    return map
    
}