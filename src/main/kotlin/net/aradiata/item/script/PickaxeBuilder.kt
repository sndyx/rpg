package net.aradiata.item.script

import net.aradiata.item.Pickaxe

@ItemDsl
abstract class PickaxeBuilder : ItemBuilder<Pickaxe>() {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build() = Pickaxe(
        id!!, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}