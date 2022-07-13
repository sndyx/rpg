package net.aradiata.item

import net.aradiata.utility.colored
import org.bukkit.Material

interface Tool : Item {
    
    val details: List<String>
    override val material: Material
        get() = Material.NETHERITE_HOE
    
    override fun writeDetails(lore: MutableList<String>) {
        lore.addAll(details.map { "&f$it".colored() })
    }
    
}