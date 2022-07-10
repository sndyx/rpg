package net.aradiata.item.impl.bundle

import net.aradiata.item.Bundle
import net.aradiata.item.Item
import net.aradiata.item.impl.Fiber
import net.aradiata.item.impl.Seeds
import kotlin.random.Random

object GrassBreakBundle : Bundle {

    override fun next(): List<Item> = buildList {
        if (Random.nextInt(1, 6) == 1) add(Seeds)
        if (Random.nextInt(1, 8) == 1) add(Fiber)
    }

}