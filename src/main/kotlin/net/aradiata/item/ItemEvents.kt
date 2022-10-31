package net.aradiata.item

import kotlinx.coroutines.CoroutineScope
import org.bukkit.entity.Player

class ItemEvents {
    var onEquip: (suspend CoroutineScope.(Player) -> Unit)? = null
    var onUnequip: (suspend CoroutineScope.(Player) -> Unit)? = null
    var onRightClick: (suspend CoroutineScope.(Player) -> Unit)? = null
    var onLeftClick: (suspend CoroutineScope.(Player) -> Unit)? = null
    var onHitPlayer: (suspend CoroutineScope.(Player, Player, Float) -> Unit)? = null
    var onKillPlayer: (suspend CoroutineScope.(Player, Player) -> Unit)? = null
}