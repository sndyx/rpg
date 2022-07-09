package net.aradiata.item

import net.aradiata.item.impl.LightningTyphoon

object Items {

    val registry: MutableMap<String, Item> = mutableMapOf()

    init {
        registry.putAll(arrayOf(
            LightningTyphoon
        ).associateBy { it.id })
    }

}