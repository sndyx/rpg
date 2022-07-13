package net.aradiata.player

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import net.aradiata.item.Item
import net.aradiata.item.Items
import net.aradiata.serialization.serializePlayerData
import org.bukkit.entity.Player
import kotlin.io.path.*

val json = Json { prettyPrint = true }

class PlayerData(private val player: Player) {
    
    init {
        val folder = Path("rpg/players/${player.uniqueId}")
        if (folder.notExists()) {
            folder.createDirectory()
            folder.resolve("meta.json").writeText(json.encodeToString(buildJsonObject {
                put("name", player.name)
                put("rank", Rank.Default.name)
                put("profile", 0)
            }))
            folder.resolve("0.profile.json").writeText(
                json.encodeToString(serializePlayerData(player))
            )
        }
    }
    
    var rank: Rank
        get() = Rank.valueOf(json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/meta.json").readText())["rank"]!!.jsonPrimitive.toString())
        set(value) {
            val obj = json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/meta.json").readText()).toMutableMap()
            obj["name"] = JsonPrimitive(value.name)
            Path("rpg/players/${player.uniqueId}/meta.json").writeText(json.encodeToString(obj))
        }
    
    var profile: Int
        get() = json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/meta.json").readText())["profile"]!!.jsonPrimitive.int
        set(value) {
            val obj = json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/meta.json").readText()).toMutableMap()
            obj["profile"] = JsonPrimitive(value)
            Path("rpg/players/${player.uniqueId}/meta.json").writeText(json.encodeToString(obj))
        }
    
    var inventory: List<Item?>
        get() = json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/$profile.profile.json").readText())["inventory"]!!.jsonArray.map {
            Items.registry[it.jsonPrimitive.toString()]
        }.toList()
        set(value) {
            val obj = json.decodeFromString<JsonObject>(Path("rpg/players/${player.uniqueId}/$profile.profile.json").readText()).toMutableMap()
            obj["inventory"] = buildJsonArray { value.forEach { add(JsonPrimitive(it?.id)) } }
            Path("rpg/players/${player.uniqueId}/$profile.profile.json").writeText(json.encodeToString(obj))
        }
    
}