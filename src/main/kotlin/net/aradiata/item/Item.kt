package net.aradiata.item

import net.aradiata.utility.*
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.io.Serializable

interface Item : Serializable {
    
    val id: String
    val texId: Int
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
            else -> error("")
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
        if (lore.size == 1) lore.removeAt(0)
        if (description != null) {
            lore.add("")
            writeWrappingText(lore, "&8${description}".colored())
        }
        lore.add("")
        lore.add("&${rarity.colorCode}&l${rarity.name}".colored())
        data.lore = lore
        data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        data.getNbt<NbtCompound>("tag")?.set("Damage", texId)
    }
    
}