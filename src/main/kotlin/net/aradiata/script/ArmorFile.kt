package net.aradiata.script

import net.aradiata.item.Armor
import net.aradiata.item.ArmorStat
import net.aradiata.item.ArmorStatType
import net.aradiata.item.ArmorType
import kotlin.properties.Delegates
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "armor.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
class ArmorFile : ItemFile<Armor>() {
    
    var type: ArmorType by Delegates.notNull()
    
    private val stats: MutableList<ArmorStat> = mutableListOf()
    fun stats(builder: MutableList<ArmorStat>.() -> Unit) = buildList(builder)
    
    override fun build(id: String) = Armor(
        id, model, name, rarity, description, events, type, stats
    )
    
}

fun MutableList<ArmorStat>.melee(value: Double) = add(ArmorStat(ArmorStatType.Melee, value))
fun MutableList<ArmorStat>.magic(value: Double) = add(ArmorStat(ArmorStatType.Magic, value))
fun MutableList<ArmorStat>.ranged(value: Double) = add(ArmorStat(ArmorStatType.Ranged, value))

fun MutableList<ArmorStat>.health(value: Double) = add(ArmorStat(ArmorStatType.Health, value))
fun MutableList<ArmorStat>.mana(value: Double) = add(ArmorStat(ArmorStatType.Mana, value))
fun MutableList<ArmorStat>.speed(value: Double) = add(ArmorStat(ArmorStatType.Speed, value))
fun MutableList<ArmorStat>.attackSpeed(value: Double) = add(ArmorStat(ArmorStatType.AttackSpeed, value))