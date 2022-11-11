package net.aradiata.item.dsl

import net.aradiata.item.Resource

fun resource(id: String, builder: ResourceBuilder.() -> Unit) =
    ResourceBuilder(id).apply(builder).build()

@ItemDsl
class ResourceBuilder(id: String) : ItemBuilder<Resource>(id) {
    
    override fun build() = Resource(
        id, model!!, name!!, rarity!!, description, events
    )
    
}