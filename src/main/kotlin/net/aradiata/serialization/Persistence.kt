package net.aradiata.serialization

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import net.aradiata.utility.getNbt
import org.bukkit.entity.Player

fun serializePlayerData(player: Player): JsonObject =
    buildJsonObject {
        put("inventory", buildJsonArray {
            player.inventory.contents
                .map { it?.itemMeta?.getNbt<String>("id") }
                .forEach { add(JsonPrimitive(it)) }
        })
        put("location", buildJsonObject {
            // put("world", JsonPrimitive(player.world.uid.toString()))
            // Commented unless we need world data for whatever reason
            put("direction", buildJsonObject {
                put("pitch", JsonPrimitive(player.location.pitch))
                put("yaw", JsonPrimitive(player.location.yaw))
            })
            put("x", JsonPrimitive(player.location.x))
            put("y", JsonPrimitive(player.location.y))
            put("z", JsonPrimitive(player.location.z))
        })
    }