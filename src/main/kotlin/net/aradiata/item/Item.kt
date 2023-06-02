package net.aradiata.item

import net.aradiata.text.addWrappingText
import net.aradiata.text.localize
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_19_R3.inventory.CraftItemStack
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

interface Item {

    val id: String
    val model: Int
    val material: Material
    val rarity: Rarity

    fun lore(): List<String>

    fun onEquip() { /* Ignore */ }
    fun onUnequip() { /* Ignore */ }
    fun onLeftClick(player: Player) { /* Ignore */ }
    fun onRightClick(player: Player) { /* Ignore */ }

    fun new(): ItemStack {
        val item = ItemStack(material, 1)
        val nms = CraftItemStack.asNMSCopy(item)
        val nbt = nms./*getNbtCompound*/v()
        nbt./*putString*/a("RpgId", id)
        nms./*setNbtCompound*/c(nbt)
        val stack = CraftItemStack.asBukkitCopy(nms)
        syncMeta(stack)
        // syncText(stack, locale)
        // Handle localization elsewhere as to not force all usages to inherit locale parameter
        return stack
    }

    fun syncMeta(item: ItemStack) {
        val meta = item.itemMeta ?: error("Achievement unlocked: How did we get here")
        meta.isUnbreakable = true
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        meta.setCustomModelData(model)
        item.itemMeta = meta
    }

    fun syncText(item: ItemStack, locale: String) {
        // Get localizations
        val name = localize("item.$id.name", locale)
        val description = localize("item.$id.description", locale)
            .takeIf { it != "item.$id.description" } // Check for no description
        val rarityName = localize(rarity.translationKey, locale)
        // Sync text
        val meta = item.itemMeta ?: error("Achievement unlocked: How did we get here")
        meta.setDisplayName("§${rarity.colorCode}$name")
        val lore = mutableListOf<String>()
        lore.add("")
        lore.addAll(lore()) // Add type-specific lore
        if (lore.size == 1) lore.removeAt(0)
        if (description != null) {
            lore.add("")
            // FIXME: Account for shitty wrapping of languages without spaces... This is hell
            // Not really a huge problem if item names and descriptions arent localized which is likely
            lore.addWrappingText("§8${description}")
        }
        lore.add("")
        lore.add("§${rarity.colorCode}§l$rarityName")
        meta.lore = lore
        item.itemMeta = meta
    }

}