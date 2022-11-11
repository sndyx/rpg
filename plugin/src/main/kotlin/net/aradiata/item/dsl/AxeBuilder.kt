package net.aradiata.item.dsl

import net.aradiata.item.Axe

fun axe(id: String, builder: AxeBuilder.() -> Unit) =
    AxeBuilder(id).apply(builder).build()

@ItemDsl
class AxeBuilder(id: String) : ItemBuilder<Axe>(id) {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build() = Axe(
        id, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}