package net.aradiata.dsl

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

fun menu(rows: Int, name: String, builder: Menu.() -> Unit): Inventory {
    val menu = Menu(rows).apply(builder)
    val inventory = Bukkit.createInventory(null, rows * 9, name)
    menu.slots.forEachIndexed { index, item ->
        inventory.setItem(index, item)
    }
    return inventory
}

class Menu(rows: Int) {

    val slots: Array<ItemStack?> = Array(rows * 9) { null }

    fun slot(row: Int, column: Int, stack: ItemStack) {
        slots[row - 1 + (column - 1) * 9] = stack
    }

    fun slot(index: Int, stack: ItemStack) {
        slots[index] = stack
    }

}
