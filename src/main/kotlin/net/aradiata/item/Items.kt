package net.aradiata.item

import net.aradiata.item.impl.Fiber
import net.aradiata.item.impl.LightningTyphoon
import net.aradiata.item.impl.Seeds

object Items {

    val registry: MutableMap<String, Item> = mutableMapOf()

    init {
        registry.putAll(arrayOf(
            LightningTyphoon,
            Fiber,
            Seeds
        ).associateBy { it.id })
    }

}