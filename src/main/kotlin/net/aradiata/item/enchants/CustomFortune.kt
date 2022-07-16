package net.aradiata.item.enchants

object CustomFortune : CustomEnchant("CustomFortune") {

    init {
        registerEnchantment(this)
    }

    override fun getName(): String = "Fortune"

    override fun getMaxLevel(): Int = 5

}