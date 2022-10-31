package net.aradiata.player

import org.bukkit.entity.Player

class RpgPlayer(val player: Player) {

    var health: Float = 0.0f
    var mana: Float = 0.0f
    
    var maxHealth: Float = 0.0f
    var maxMana: Float = 0.0f
    
    val data: PlayerData = PlayerData()
    
    init {
        // calculate()
    }

}