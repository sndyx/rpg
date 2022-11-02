package net.aradiata.player

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.aradiata.item.ItemData
import net.aradiata.item.ItemRegistry
import org.bukkit.entity.Player
import kotlin.io.path.*

class PlayerHandle(val player: Player) {
    
    var health = 20
    var mana = 20
    
    val data = PlayerData(player)
    
    fun save() {
        data.profile = serialize(player)
        data.save()
    }
    
}

val json = Json { prettyPrint = true }

class PlayerData(player: Player) {
    
    private val folder = Path("rpg/players/${player.uniqueId}")
    
    var meta: PlayerMeta
    var profile: Profile
    
    fun save() {
        writeJsonToFolder("meta.json", meta)
        writeJsonToFolder("${meta.profile}.profile.json", profile)
    }
    
    init {
        if (folder.notExists()) {
            folder.createDirectory()
            meta = PlayerMeta(
                player.name,
                Rank.Default.name,
                0
            )
            profile = serialize(player)
        } else {
            meta = readJsonFromFolder("meta.json")
            profile = readJsonFromFolder("${meta.profile}.profile.json")
        }
    }
    
    private inline fun <reified T> writeJsonToFolder(fileName: String, obj: T) {
        folder.resolve(fileName).writeText(json.encodeToString(obj))
    }
    
    private inline fun <reified T> readJsonFromFolder(fileName: String): T {
        return json.decodeFromString(folder.resolve(fileName).readText())
    }
    
}

fun serialize(player: Player): Profile =
    Profile(
        player.inventory.map { stack ->
            stack
                .takeIf { it.itemMeta?.hasCustomModelData() == true }
                ?.itemMeta?.customModelData?.let { model ->
                    ItemRegistry
                        .find { it.model == model }
                        ?.let { ItemData(it.id, stack.amount) }
                }
        },
        ProfileLocation(
            ProfileLocationDirection(
                player.location.pitch,
                player.location.yaw
            ),
            player.location.x,
            player.location.y,
            player.location.z
        )
    )