package net.aradiata.item

import net.aradiata.item.impl.*

object Items {

    val registry: MutableMap<Int, Item> = mutableMapOf()

    init {
        registry.putAll(arrayOf(
            LightningTyphoon,
            PinkSpell,
            Fiber,
            Seeds,
            Dandelion,
            Wheat,
            WoodenHoe,
            TheHoeOfAllHoes,
            Coal,
        ).associateBy { it.id })
    }

}