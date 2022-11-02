package net.aradiata.player

import kotlinx.serialization.Serializable
import net.aradiata.item.ItemData

@Serializable
class PlayerMeta(
    val name: String,
    val rank: String,
    val profile: Int
)

@Serializable
class Profile(
    val inventory: List<ItemData?>,
    val location: ProfileLocation
)

@Serializable
class ProfileLocation(
    val direction: ProfileLocationDirection,
    val x: Double,
    val y: Double,
    val z: Double
)

@Serializable
class ProfileLocationDirection(
    val pitch: Float, val yaw: Float
)