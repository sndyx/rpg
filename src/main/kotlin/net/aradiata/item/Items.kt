package net.aradiata.item

import net.aradiata.item.impl.*

object Items {

    val registry: MutableMap<String, Item> = mutableMapOf()

    init {
        registry.putAll(arrayOf(
            LightningTyphoon,
            PinkSpell,
            Fiber,
            Seeds
        ).associateBy { it.id })
    }

}