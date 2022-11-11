package net.aradiata.item.dsl

import net.aradiata.item.Pickaxe

fun pickaxe(id: String, builder: PickaxeBuilder.() -> Unit) =
    PickaxeBuilder(id).apply(builder).build()

@ItemDsl
class PickaxeBuilder(id: String) : ItemBuilder<Pickaxe>(id) {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build() = Pickaxe(
        id, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}