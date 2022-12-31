package net.aradiata.item.script

import net.aradiata.item.Resource

@ItemDsl
abstract class ResourceBuilder : ItemBuilder<Resource>() {
    
    override fun build() = Resource(
        id!!, model!!, name!!, rarity!!, description, events
    )
    
}