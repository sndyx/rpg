package net.aradiata.item

import org.bukkit.Material

interface Resource : Item {

    override val material: Material get() = Material.STICK

}

fun resource(
    id: String,
    model: Int,
    material: Material,
    rarity: Rarity
): Resource = object : Resource {
    override val id: String = id
    override val model: Int = model
    override val material: Material = material
    override val rarity: Rarity = rarity

    override fun lore(): List<String> = emptyList()
}