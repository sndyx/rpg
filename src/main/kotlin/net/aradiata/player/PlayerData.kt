package net.aradiata.player

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.aradiata.item.ItemData
import net.aradiata.item.Items
import org.bukkit.entity.Player
import kotlin.io.path.*

// this should be one instance
val json = Json { prettyPrint = true }

// this should probably be kept cached
class PlayerData(private val player: Player) {

    private val folder
     get() = Path("rpg/players/${player.uniqueId}")

    private fun writeJsonToFolder(fileName: String, obj: () -> Any) {
        folder.resolve(fileName).writeText(json.encodeToString(obj))
    }

    private inline fun <reified T> readJsonFromFolder(fileName: String): T {
        return json.decodeFromString(folder.resolve(fileName).readText())
    }

    
    var meta: PlayerMeta
        get() = readJsonFromFolder("meta.json")
        set(value) {
            writeJsonToFolder("meta.json") {
                value
            }
        }

    var activeProfile: Profile
        get() = readJsonFromFolder("${meta.profile}.profile.json")
        set(value) {
            writeJsonToFolder("${meta.profile}.profile.json") {
                value
            }
        }

    // so scuffed
    init {
        if (folder.notExists()) {
            folder.createDirectory()
            meta = PlayerMeta(
                player.name,
                Rank.Default.name,
                0
            )

            activeProfile = serializePlayerData(player)
        }
    }
}

fun serializePlayerData(player: Player): Profile =
    Profile(
        player.inventory.map { stack ->
            if (stack?.itemMeta?.hasCustomModelData() == true) stack.itemMeta!!.customModelData.let {
                Items.registry[it]?.configId?.let { it1 -> ItemData(it1, stack.amount) }
            } else null
        },
        ProfileLocation(
            ProfileLocationDirection(
                player.location.pitch,
                player.location.yaw,
            ),
            player.location.x,
            player.location.y,
            player.location.z
        )
    )