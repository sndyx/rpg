package net.aradiata.item

import org.bukkit.Material

class Weapon(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents,
    val stats: List<WeaponStat>,
    val suppressMeleeDamage: Boolean
) : Item(id, model, name, rarity, description, events) {
    
    override val material: Material = Material.STICK
    override fun writeDetails(lore: MutableList<String>) {
        stats.sortedWith(compareBy<WeaponStat> { it.type.ordinal }.thenBy { it.chance }.thenBy { it.value }).apply {
            filter { it.type.isPrimary }.forEach {
                lore.add("§f${it.type.displayName}: §${rarity.colorCode}+${it.value} ${if (it.chance != 100.0) "§8(${it.chance}%)" else ""}")
            }
            filterNot { it.type.isPrimary }.also { if (it.isNotEmpty()) lore.add("") }.forEach {
                lore.add("§f${it.type.displayName}: §${rarity.colorCode}+${it.value} ${if (it.chance != 100.0) "§8(${it.chance}%)" else ""}")
            }
        }
    }
    
}

class WeaponStat(val type: WeaponStatType, val value: Double, val chance: Double)

enum class WeaponStatType(val isPrimary: Boolean, val displayName: String) {
    
    Melee(true, "Melee Damage"),
    Magic(true, "Magic Damage"),
    Ranged(true, "Ranged Damage"),
    
    AttackSpeed(false, "Attack Speed");
    
}