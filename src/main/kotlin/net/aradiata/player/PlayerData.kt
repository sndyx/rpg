package net.aradiata.player

import kotlinx.serialization.Serializable
import net.aradiata.item.ItemData

@Serializable
class PlayerMeta(
    val name: String,
    var rank: String,
    var profile: Int
)

@Serializable
class Profile(
    val inventory: List<ItemData?>,
    val location: ProfileLocation
) {

    constructor() : this(
        emptyList(),
        ProfileLocation(ProfileLocationDirection(0.0f, 0.0f), -85.5, 64.0, 596.5)
    )

}

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