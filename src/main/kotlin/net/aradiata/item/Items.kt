package net.aradiata.item

import org.bukkit.inventory.ItemStack

val ItemStack.item: Item get() = TODO("UHHHhhhh")

fun ItemStack.localize(locale: String) {
    item.syncText(this, locale)
}