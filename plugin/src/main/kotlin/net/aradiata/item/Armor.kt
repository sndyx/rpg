package net.aradiata.item

import org.bukkit.Material

class Armor(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents,
    val type: ArmorType,
    val stats: List<ArmorStat>,
    ) : Item(
    id, model, name, rarity, description, events
) {
    
    override val material: Material = when (type) {
        ArmorType.Helmet -> Material.NETHERITE_HELMET
        ArmorType.Chestplate -> Material.NETHERITE_CHESTPLATE
        ArmorType.Leggings -> Material.NETHERITE_LEGGINGS
        ArmorType.Boots -> Material.NETHERITE_BOOTS
    }
    
    override fun writeDetails(lore: MutableList<String>) {
        stats.sortedWith(compareBy<ArmorStat> { it.type.ordinal }.thenBy { it.value }).apply {
            filter { it.type.isPrimary }.forEach {
                lore.add("§f${it.type.displayName}: §${rarity.colorCode}+${it.value}%")
            }
            filterNot { it.type.isPrimary }.also { if (it.isNotEmpty()) lore.add("") }.forEach {
                lore.add("§f${it.type.displayName}: §${rarity.colorCode}+${it.value}")
            }
        }
    }
    
}

enum class ArmorType {
    
    Helmet,
    Chestplate,
    Leggings,
    Boots
    
}

class ArmorStat(val type: ArmorStatType, val value: Double)

enum class ArmorStatType(val isPrimary: Boolean, val displayName: String) {
    
    Melee(true, "Melee Damage"),
    Magic(true, "Magic Damage"),
    Ranged(true, "Ranged Damage"),
    
    Health(false, "Health"),
    Defense(false, "Defense"),
    Mana(false, "Mana"),
    Speed(false, "Speed"),
    AttackSpeed(false, "Attack Speed"),
    
}