package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Rarity

abstract class BaseItemDelegate {
    
    var id: String? = null
    var name: String? = null
    var rarity: Rarity? = null
    var description: String? = null
    
    fun checkValuesAssigned() {
        checkNotNull(id)
        checkNotNull(name)
        checkNotNull(rarity)
    }
    
    fun toItem(): Item {
        checkValuesAssigned()
        return convertToItem()
    }
    
    abstract fun convertToItem(): Item
    
}