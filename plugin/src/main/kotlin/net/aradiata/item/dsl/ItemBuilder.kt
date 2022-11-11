package net.aradiata.item.dsl

import kotlinx.coroutines.CoroutineScope
import net.aradiata.item.Item
import net.aradiata.item.ItemEvents
import net.aradiata.item.Rarity
import org.bukkit.entity.Player

abstract class ItemBuilder<T : Item>(val id: String) {
    
    var model: Int? = null
    var name: String? = null
    var rarity: Rarity? = null
    var description: String? = null
    var events: ItemEvents = ItemEvents()
    
    fun events(builder: ItemEvents.() -> Unit) = builder(events)
    
    abstract fun build(): T
    
}

fun ItemEvents.onEquip(action: suspend CoroutineScope.(Player) -> Unit) { equip = action }
fun ItemEvents.onUnequip(action: suspend CoroutineScope.(Player) -> Unit) { unequip = action }
fun ItemEvents.onRightClick(action: suspend CoroutineScope.(Player) -> Unit) { rightClick = action }
fun ItemEvents.onLeftClick(action: suspend CoroutineScope.(Player) -> Unit) { leftClick = action }
fun ItemEvents.onHitPlayer(action: suspend CoroutineScope.(Player, Player, Float) -> Unit) { hitPlayer = action }
fun ItemEvents.onKillPlayer(action: suspend CoroutineScope.(Player, Player) -> Unit) { killPlayer = action }