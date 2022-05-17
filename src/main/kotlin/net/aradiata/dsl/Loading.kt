package net.aradiata.dsl

import net.aradiata.item.Item
import kotlin.io.path.Path
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.name

fun loadItems(): Map<String, Item> {
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
        result.onFailure { exception ->
            println("Error loading item: ${it.name}!")
            exception.printStackTrace()
        }
        result.onSuccess { item ->
            map[item.id] = item
        }
    }
    return map
}