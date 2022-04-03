package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Rarity

abstract class ItemDelegate {
    
    var id: String? = null
    var name: String? = null
    var rarity: Rarity? = null
    var description: String? = null
    
    abstract fun toItem(): Item
    
    fun checkProperties() {
        checkNotNull(id) { "Property `id` must be assigned." }
        checkNotNull(name) { "Property `name` must be assigned." }
        checkNotNull(rarity) { "Property `rarity` must be assigned." }
    }
    
}