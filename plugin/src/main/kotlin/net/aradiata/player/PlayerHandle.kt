package net.aradiata.player

import kotlinx.coroutines.Job
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.aradiata.item.*
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack
import org.bukkit.entity.Player
import kotlin.io.path.*

class PlayerHandle(val player: Player) {
    
    val jobs = mutableListOf<Job>()
    
    val state = PlayerState()
    val data = PlayerData(this)
    
    fun save() {
        data.save()
    }
    
    init {
        scheduleTasks()
        updateArmor()
    }
    
}

val json = Json { prettyPrint = true }

class PlayerData(val handle: PlayerHandle) {
    
    private val folder = Path("rpg/players/${handle.player.uniqueId}")
    
    var meta: PlayerMeta
    var profile: Profile
    
    fun save() {
        syncProfile()
        writeJsonToFolder("meta.json", meta)
        writeJsonToFolder("${meta.profile}.profile.json", profile)
    }
    
    fun load(profileNumber: Int) {
        save()
        meta.profile = profileNumber
        profile = if (folder.resolve("$profileNumber.profile.json").exists()) {
            readJsonFromFolder("$profileNumber.profile.json")
        } else {
            Profile.new()
        }
        syncPlayer()
    }
    
    private fun syncPlayer() {
        handle.player.teleport(
            Location(
                Bukkit.getWorld("main"),
                profile.location.x, profile.location.y, profile.location.z,
                profile.location.direction.yaw, profile.location.direction.pitch
            )
        )
        handle.player.inventory.contents = profile.inventory.map { data ->
            data?.id?.let { id -> ItemRegistry.find { it.id == id } }
                ?.toItemStack()
                ?.apply { amount = data.amount }
        }.toTypedArray()
        handle.updateArmor()
        handle.updateWeapon()
    }
    
    private fun syncProfile() {
        profile = Profile(
            handle.player.inventory.map { item ->
                item?.let { stack ->
                    val nbt = CraftItemStack.asNMSCopy(stack).v()
                    val rpgId = nbt.l("RpgId").takeUnless { it == "" }
                    rpgId?.let { ItemData(it, item.amount) }
                }
            },
            ProfileLocation(
                ProfileLocationDirection(
                    handle.player.location.pitch,
                    handle.player.location.yaw
                ),
                handle.player.location.x,
                handle.player.location.y,
                handle.player.location.z
            )
        )
    }
    
    init {
        if (folder.notExists()) {
            folder.createDirectory()
            meta = PlayerMeta(
                handle.player.name,
                Rank.Default.name,
                0
            )
            profile = Profile.new()
        } else {
            meta = readJsonFromFolder("meta.json")
            profile = readJsonFromFolder("${meta.profile}.profile.json")
        }
        syncPlayer()
    }
    
    private inline fun <reified T> writeJsonToFolder(fileName: String, obj: T) {
        folder.resolve(fileName).writeText(json.encodeToString(obj))
    }
    
    private inline fun <reified T> readJsonFromFolder(fileName: String): T {
        return json.decodeFromString(folder.resolve(fileName).readText())
    }
    
}

class PlayerState {
    // calculate damage on next hit
    var weaponFlag = true
    
    var maxHealth: Double = 20.0
    var maxMana: Double = 20.0
    var mana: Double = maxMana
    var defense: Double = 0.0
    var offsetDefense: Double = 0.0
    
    var damage: Double = 1.0
    var increaseMelee: Double = 0.0
    var increaseMagic: Double = 0.0
    var increaseRanged: Double = 0.0
    
    var ignoreMelee = false
}