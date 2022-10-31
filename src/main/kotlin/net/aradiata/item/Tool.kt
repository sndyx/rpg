package net.aradiata.item

abstract class Tool(
    id: String,
    model: Int,
    name: String,
    rarity: Rarity,
    description: String?,
    events: ItemEvents
) : Item(id, model, name, rarity, description, events)