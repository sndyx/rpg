package net.aradiata.player

import kotlinx.serialization.serializer
import net.aradiata.Plugin
import net.aradiata.sfx.SoundController
import net.aradiata.ui.OverlayController
import org.bukkit.entity.Player
import java.io.Closeable
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText

class PlayerController(val player: Player) : Closeable {

    private val folder = Path("rpg/players/${player.uniqueId}")

    val meta: PlayerMeta = readJson("meta.json")
    var profile: Profile = readJson("${meta.profile}.profile.json")
    val state = PlayerState()

    val ui = OverlayController(player)
    val sound = SoundController(player)

    var ticks = 0
    fun tick() {
        if (ticks % 2 == 0) ui.tick()
        if (ticks % 20 == 0) sound.tick()
        ticks++
    }

    override fun close() {
        writeJson("meta.json", meta)
        writeJson("${meta.profile}.profile.json", profile)
        sound.channel.close()
    }

    private inline fun <reified T> readJson(fileName: String): T {
        return Plugin.json.decodeFromString(
            serializer(),
            folder.resolve(fileName).readText()
        )
    }

    private inline fun <reified T> writeJson(fileName: String, obj: T) {
        folder.resolve(fileName).writeText(
            Plugin.json.encodeToString(serializer(), obj)
        )
    }

}