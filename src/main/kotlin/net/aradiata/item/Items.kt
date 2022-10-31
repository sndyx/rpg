package net.aradiata.item

import net.aradiata.Config
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

fun Item.toItemStack(): ItemStack {
    val item = ItemStack(Material.STICK, 1)
    val meta = item.itemMeta
    sync(meta!!)
    item.itemMeta = meta // Not a reference for whatever godforsaken reason
    return item
}

fun Item.sync(data: ItemMeta) {
    data.setDisplayName("§${rarity.colorCode}$name")
    val lore = mutableListOf<String>()
    lore.add("")
    writeDetails(lore)
    if (lore.size == 1) lore.removeAt(0)
    if (description != null) {
        lore.add("")
        lore.addWrappingText("§8${description}")
    }
    lore.add("")
    lore.add("§${rarity.colorCode}§l${rarity.name}")
    data.lore = lore
    data.isUnbreakable = true
    data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
    data.setCustomModelData(model)
}

private fun MutableList<String>.addWrappingText(text: String) {
    val words = text.split(' ')
    var lastColor = 'f'
    var line = ""
    words.forEach { word ->
        var i = 0
        var actualLength = 0
        while (i < word.length) {
            if (word[i] == '§') {
                lastColor = word[i + 1]
                i += 2
            } else {
                actualLength++
                i++
            }
        }
        if (actualLength > Config.lineLength) {
            add(line)
            add("§$lastColor$word")
        } else if (line.length + actualLength > Config.lineLength) {
            add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }
        
    }
    add(line)
}