package net.aradiata.item

import net.aradiata.utility.colored
import net.aradiata.utility.writeWrappingText
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

interface Item {
    
    val id: String
    val name: String
    val rarity: Rarity
    val description: String?
    
    fun writeDetails(lore: MutableList<String>)
    
    fun create(): ItemStack {
        val material: Material = when (this) {
            is Resource -> {
                Material.NETHERITE_HOE
            }
            is Weapon -> {
                Material.NETHERITE_SWORD
            }
            else -> error("d")
        }
        val item = ItemStack(material, 1)
        val meta = item.itemMeta
        sync(meta!!)
        item.itemMeta = meta // Not a reference for whatever godforsaken reason
        return item
    }
    
    fun sync(data: ItemMeta) {
        data.setDisplayName("&${rarity.colorCode}&l$name".colored())
        val lore = mutableListOf<String>()
        lore.add("")
        writeDetails(lore)
        if (description != null) {
            lore.add("")
            writeWrappingText(lore, "&8&o${description}".colored())
        }
        lore.add("")
        lore.add("&${rarity.colorCode}&l${rarity.name}".colored())
        data.lore = lore
    }
    
}