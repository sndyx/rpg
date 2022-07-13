package net.aradiata.item

import org.bukkit.Material

interface Resource : Item {

    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }

}