package net.aradiata.script

import kotlinx.coroutines.CoroutineScope
import net.aradiata.item.Item
import net.aradiata.item.ItemEvents
import net.aradiata.item.Rarity
import org.bukkit.entity.Player

abstract class ItemFile<T : Item> : java.io.Serializable {
    
    var model: Int? = null
    var name: String? = null
    var rarity: Rarity? = null
    var description: String? = null
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