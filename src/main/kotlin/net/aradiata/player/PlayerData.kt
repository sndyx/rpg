package net.aradiata.player

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import net.aradiata.item.ItemData
import net.aradiata.item.Items
import net.aradiata.utility.NbtCompound
import net.aradiata.utility.get
import net.aradiata.utility.getNbt
import org.bukkit.entity.Player
import kotlin.io.path.*

val json = Json { prettyPrint = true }

class PlayerData(private val player: Player) {
    
    init {
        val folder = Path("rpg/players/${player.uniqueId}")
        if (folder.notExists()) {
            folder.createDirectory()
            folder.resolve("meta.json").writeText(json.encodeToString(PlayerMeta(
                player.name,
                Rank.Default.name,
                0
            )))
            folder.resolve("0.profile.json").writeText(
                json.encodeToString(serializePlayerData(player))
            )
        }
    }
    
    var meta: PlayerMeta
        get() = json.decodeFromString(Path("rpg/players/${player.uniqueId}/meta.json").readText())
        set(value) {
            Path("rpg/players/${player.uniqueId}/meta.json").writeText(json.encodeToString(value))
        }
    
    var activeProfile: Profile
        get() = getProfile(meta.profile)
        set(value) {
            setProfile(meta.profile, value)
        }
    
    fun getProfile(n: Int): Profile {
        return json.decodeFromString(Path("rpg/players/${player.uniqueId}/$n.profile.json").readText())
    }
    
    fun setProfile(n: Int, value: Profile) {
        Path("rpg/players/${player.uniqueId}/$n.profile.json").writeText(json.encodeToString(value))
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