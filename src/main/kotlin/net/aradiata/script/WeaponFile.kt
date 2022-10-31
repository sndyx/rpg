package net.aradiata.script

import net.aradiata.item.*
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "weapon.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
abstract class WeaponFile : ItemFile<Weapon>() {
    
    private var suppressMeleeDamage: Boolean = false
    fun suppressMeleeDamage() { suppressMeleeDamage = true }
    
    private val stats: MutableList<WeaponStat> = mutableListOf()
    fun stats(builder: MutableList<WeaponStat>.() -> Unit) = buildList(builder)
    
    override fun build(id: String) = Weapon(
        id, model, name, rarity, description, events, stats, suppressMeleeDamage
    )
    
}

fun MutableList<WeaponStat>.melee(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Melee, value, chance))
fun MutableList<WeaponStat>.magic(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Magic, value, chance))
fun MutableList<WeaponStat>.ranged(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.Ranged, value, chance))
fun MutableList<WeaponStat>.speed(value: Double, chance: Double = 100.0) = add(WeaponStat(WeaponStatType.AttackSpeed, value, chance))