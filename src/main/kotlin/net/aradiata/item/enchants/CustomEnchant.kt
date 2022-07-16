package net.aradiata.item.enchants

import net.aradiata.PluginScope
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentTarget
import org.bukkit.inventory.ItemStack
import java.lang.StringBuilder


abstract class CustomEnchant(name: String) : Enchantment(NamespacedKey(PluginScope.instance, name)) {

    override fun getStartLevel(): Int = 1

    override fun getItemTarget(): EnchantmentTarget = EnchantmentTarget.ALL

    override fun isTreasure(): Boolean = false

    override fun isCursed(): Boolean = false

    override fun canEnchantItem(item: ItemStack): Boolean = false

    override fun conflictsWith(other: Enchantment): Boolean = false

    private val map = linkedMapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    private fun toRoman(number: Int): String {
        var number = number // so bad

        val result = StringBuilder()

        for (entry in map.entries) {
            while (number > entry.key) {
                number -= entry.key
                result.append(entry.value)
            }
        }

        return result.toString()
    }

    fun getEnchantName(level: Int): String {
        if(level == 1 && maxLevel == 1){
            return name
        } else if (level < 0) {
            return "$name -${toRoman(level)}"
        }

        return "$name ${toRoman(level)}"
    }
}