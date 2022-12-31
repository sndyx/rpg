package net.aradiata.item.script

import net.aradiata.item.*

fun armor(builder: ArmorBuilder.() -> Unit) =
    ArmorBuilder().apply(builder).build()

class ArmorBuilder : ItemBuilder<Armor>() {
    
    var type: ArmorType? = null
    
    private val stats: MutableList<ArmorStat> = mutableListOf()
    
    fun stats(builder: MutableList<ArmorStat>.() -> Unit) = stats.addAll(buildList(builder))
    
    
    override fun build() = Armor(
        id!!, model!!, name!!, rarity!!, description, events, type!!, stats
    )
    
}

fun MutableList<ArmorStat>.melee(value: Double) = add(ArmorStat(ArmorStatType.Melee, value))
fun MutableList<ArmorStat>.magic(value: Double) = add(ArmorStat(ArmorStatType.Magic, value))
fun MutableList<ArmorStat>.ranged(value: Double) = add(ArmorStat(ArmorStatType.Ranged, value))

fun MutableList<ArmorStat>.health(value: Double) = add(ArmorStat(ArmorStatType.Health, value))
fun MutableList<ArmorStat>.defense(value: Double) = add(ArmorStat(ArmorStatType.Defense, value))

fun MutableList<ArmorStat>.mana(value: Double) = add(ArmorStat(ArmorStatType.Mana, value))
fun MutableList<ArmorStat>.speed(value: Double) = add(ArmorStat(ArmorStatType.Speed, value))
fun MutableList<ArmorStat>.attackSpeed(value: Double) = add(ArmorStat(ArmorStatType.AttackSpeed, value))