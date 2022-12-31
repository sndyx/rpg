package net.aradiata.item.script

import net.aradiata.item.Axe

@ItemDsl
abstract class AxeBuilder : ItemBuilder<Axe>() {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build() = Axe(
        id!!, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}