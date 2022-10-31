package net.aradiata.script

import kotlinx.coroutines.CoroutineScope
import net.aradiata.item.Item
import net.aradiata.item.ItemEvents
import net.aradiata.item.Rarity
import org.bukkit.entity.Player
import kotlin.properties.Delegates

abstract class ItemFile<T : Item> {
    
    var model: Int by Delegates.notNull()
    var name: String by Delegates.notNull()
    var rarity: Rarity by Delegates.notNull()
    var description: String by Delegates.notNull()
    var events: ItemEvents = ItemEvents()
    
    fun events(builder: ItemEvents.() -> Unit) = builder(events)
    
    abstract fun build(id: String): T
    
}

fun ItemEvents.onEquip(action: suspend CoroutineScope.(Player) -> Unit) { onEquip = action }
fun ItemEvents.onUnequip(action: suspend CoroutineScope.(Player) -> Unit) { onUnequip = action }
fun ItemEvents.onRightClick(action: suspend CoroutineScope.(Player) -> Unit) { onRightClick = action }
fun ItemEvents.onLeftClick(action: suspend CoroutineScope.(Player) -> Unit) { onLeftClick = action }
fun ItemEvents.onHitPlayer(action: suspend CoroutineScope.(Player, Player, Float) -> Unit) { onHitPlayer = action }
fun ItemEvents.onKillPlayer(action: suspend CoroutineScope.(Player, Player) -> Unit) { onKillPlayer = action }