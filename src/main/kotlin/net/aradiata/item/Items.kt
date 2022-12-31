package net.aradiata.item

import org.bukkit.Color
import org.bukkit.attribute.Attribute
import org.bukkit.craftbukkit.v1_19_R2.inventory.CraftItemStack
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.LeatherArmorMeta

fun Item.toItemStack(): ItemStack {
    val item = ItemStack(material, 1)
    val nms = CraftItemStack.asNMSCopy(item)
    val nbt = nms./*getNbtCompound*/v()
    nbt./*putString*/a("RpgId", id)
    nms./*setNbtCompound*/c(nbt)
    val new = CraftItemStack.asBukkitCopy(nms)
    val meta = new.itemMeta
    sync(meta!!)
    new.itemMeta = meta // Not a reference for whatever godforsaken reason
    return new
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
    data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_DYE)
    data.removeAttributeModifier(Attribute.GENERIC_ARMOR) // TODO: fix? doesnt remove armor levels
    data.setCustomModelData(model)
    
    if (this is Armor) { // dumb solution but who cares!!!
        (data as LeatherArmorMeta).setColor(Color.fromRGB(model, 0, 0))
    }
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
        if (actualLength > 30) {
            add(line)
            add("§$lastColor$word")
        } else if (line.length + actualLength > 30) {
            add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }
        
    }
    add(line)
}

fun ItemStack.toItem(): Item? {
    return ItemRegistry.find {
        it.material == type && it.model == itemMeta?.customModelData
    }
}