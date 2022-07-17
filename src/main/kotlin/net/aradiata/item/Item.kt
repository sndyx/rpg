package net.aradiata.item

import net.aradiata.item.type.*
import net.aradiata.plugin.addWrappingText
import net.aradiata.plugin.colored
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

interface Item : Bundle {
    
    val configId: String
    val id: Int
    val name: String
    val rarity: Rarity
    val description: String?
    
    fun writeDetails(lore: MutableList<String>)
    
    companion object {
        
        fun ItemStack.toRpgItem(): Item? {
            return itemMeta?.run {
                if (hasCustomModelData()) registry[customModelData] else null
            }
        }
        
        val registry: Map<Int, Item> = listOf(
            WoodenPickaxe,
            WoodenAxe,
            WoodenHoe,
            Fiber,
            Wheat,
            Coal,
            OakWood,
            StonePickaxe
        ).associateBy { it.id }
        
    }
    
    override fun next(tool: Tool): List<Item> = buildList {
        chance(100.0, tool) { add(this@Item) }
    }

    override fun chanceIncrease(tool: Tool): Int = tool.dropIncrease
    
    fun toItemStack(): ItemStack {
        val item = ItemStack(Material.STICK, 1)
        val meta = item.itemMeta
        sync(meta!!)
        item.itemMeta = meta // Not a reference for whatever godforsaken reason
        return item
    }
    
    fun sync(data: ItemMeta) {
        data.setDisplayName("&${rarity.colorCode}$name".colored())
        val lore = mutableListOf<String>()
        lore.add("")
        writeDetails(lore)
        if (lore.size == 1) lore.removeAt(0)
        if (description != null) {
            lore.add("")
            lore.addWrappingText("&8${description}".colored())
        }
        lore.add("")
        lore.add("&${rarity.colorCode}&l${rarity.name}".colored())
        data.lore = lore
        data.isUnbreakable = true
        data.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE)
        data.setCustomModelData(id)
    }
    
}