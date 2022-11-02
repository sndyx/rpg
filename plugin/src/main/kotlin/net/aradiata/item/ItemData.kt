package net.aradiata.item

import kotlinx.serialization.Serializable

@Serializable
class ItemData(
    val id: String,
    val amount: Int,
)