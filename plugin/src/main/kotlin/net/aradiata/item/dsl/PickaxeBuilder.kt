package net.aradiata.script

import net.aradiata.item.Pickaxe

@ItemDsl
class PickaxeFile : ItemFile<Pickaxe>() {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build(id: String) = Pickaxe(
        id, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}