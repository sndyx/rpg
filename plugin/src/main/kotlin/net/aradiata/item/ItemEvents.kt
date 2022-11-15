package net.aradiata.item

import kotlinx.coroutines.CoroutineScope
import net.aradiata.player.handle
import org.bukkit.GameMode
import org.bukkit.entity.Player

class ItemEvents {
    var equip: (suspend CoroutineScope.(Player) -> Unit)? = null
    var unequip: (suspend CoroutineScope.(Player) -> Unit)? = null
    var rightClick: (suspend CoroutineScope.(Player) -> Unit)? = null
    var leftClick: (suspend CoroutineScope.(Player) -> Unit)? = null
    var hitPlayer: (suspend CoroutineScope.(Player, Player, Float) -> Unit)? = null
    var killPlayer: (suspend CoroutineScope.(Player, Player) -> Unit)? = null
}

suspend fun ability(manaUsage: Int, player: Player, action: suspend () -> Unit) {
    if (player.gameMode == GameMode.CREATIVE) {
        action()
        return
    }
    if (player.handle().state.mana < manaUsage) return
    player.handle().state.mana -= manaUsage
    action()
}