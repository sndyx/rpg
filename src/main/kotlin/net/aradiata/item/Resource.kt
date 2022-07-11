package net.aradiata.item

import org.bukkit.Material

interface Resource : Item {

    override val material: Material
        get() = Material.NETHERITE_INGOT

    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }

}