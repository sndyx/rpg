package net.aradiata.item

import net.aradiata.utility.colored
import net.aradiata.utility.writeWrappingText
import org.bukkit.inventory.meta.ItemMeta

interface Item {
    
    val id: String
    val name: String
    val rarity: Rarity
    val description: String?
    
    val eventHandler: ItemEventHandler
    
    fun writeDetails(lore: MutableList<String>)
    
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