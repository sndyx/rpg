package net.aradiata.script

import net.aradiata.item.Resource

@ItemDsl
class ResourceFile : ItemFile<Resource>() {
    
    override fun build(id: String) = Resource(
        id, model!!, name!!, rarity!!, description, events
    )
    
}