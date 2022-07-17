package net.aradiata.item

import net.aradiata.plugin.colored

interface Tool: Item {
    val power: Int
    val speed: Int
    val dropIncrease: Int

    fun buildToolLore(lore: MutableList<String>, name: String) {
        if (name != "Hoe") lore.add("&f$name Power: &${rarity.colorCode}+$power".colored())
        val speedDisplay: String = when {
            speed > 480 -> "Insanely Fast"
            speed > 360 -> "Very Fast"
            speed > 240 -> "Fast"
            speed > 120 -> "Average"
            speed > 80 -> "Slow"
            speed > 20 -> "Very Slow"
            else -> "Extremely Slow"
        }
        if (name != "Hoe") lore.add("&f$name Speed: &${rarity.colorCode}$speedDisplay".colored())
        if (dropIncrease != 0) lore.add("&fDrop Chance: &${rarity.colorCode}+$dropIncrease%".colored())
    }

}