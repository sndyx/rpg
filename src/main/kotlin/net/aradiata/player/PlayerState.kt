package net.aradiata.player

class PlayerState {

    // Recalculate stats on next hit if true
    var weaponFlag = true

    var maxHealth: Double = 20.0
    var maxMana: Double = 20.0
    var mana: Double = maxMana
    var defense: Double = 0.0
    var offsetDefense: Double = 0.0

    var damage: Double = 1.0
    var increaseMelee: Double = 0.0
    var increaseMagic: Double = 0.0
    var increaseRanged: Double = 0.0

    var ignoreMelee = false

}