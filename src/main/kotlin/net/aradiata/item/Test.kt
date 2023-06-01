package net.aradiata.item

import org.bukkit.Material
import org.bukkit.entity.Player

class Wheat : Resource by resource(
    "wheat", 1, Material.WHEAT, Rarity.Common
) {

    override fun onRightClick(player: Player) {
        println("Wheat clicked")
    }

}