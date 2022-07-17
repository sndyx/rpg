package net.aradiata.item

import net.aradiata.plugin.colored

interface Tool: Item {
    val power: Int
    val speed: Int
    val dropIncrease: Int

    fun buildToolLore(lore: MutableList<String>, name: String) {
        lore.add("&f$name Power: &${rarity.colorCode}+$power".colored())
        val speedDisplay: String = when {
            speed > 120 -> "Insanely Fast"
            speed > 100 -> "Very Fast"
            speed > 80 -> "Fast"
            speed > 60 -> "Average"
            speed > 40 -> "Slow"
            speed > 20 -> "Very Slow"
            else -> "Extremely Slow"
        }
        lore.add("&f$name Speed: &${rarity.colorCode}$speedDisplay".colored())
        lore.add("&fDrop Chance: &${rarity.colorCode}+$dropIncrease%".colored())
    }

}