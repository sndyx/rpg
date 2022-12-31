package net.aradiata.item.impl

import net.aradiata.item.ArmorType
import net.aradiata.item.Rarity
import net.aradiata.item.script.armor
import net.aradiata.item.script.defense
import net.aradiata.item.script.health
import net.aradiata.item.script.mana

fun crystal_helmet() = armor {
    model = 1
    id = "crystal_helmet"
    name = "Crystal Helmet"
    type = ArmorType.Helmet
    rarity = Rarity.Epic
    
    stats {
        health(10.0)
        defense(20.0)
        mana(10.0)
    }
}

fun crystal_chestplate() = armor {
    model = 1
    id = "crystal_chestplate"
    name = "Crystal Chestplate"
    type = ArmorType.Chestplate
    rarity = Rarity.Epic
    
    stats {
        health(10.0)
        defense(20.0)
        mana(10.0)
    }
}

fun crystal_leggings() = armor {
    model = 1
    id = "crystal_leggings"
    name = "Crystal Leggings"
    type = ArmorType.Leggings
    rarity = Rarity.Epic
    
    stats {
        health(10.0)
        defense(20.0)
        mana(10.0)
    }
}

fun crystal_boots() = armor {
    model = 1
    id = "crystal_boots"
    name = "Crystal Boots"
    type = ArmorType.Boots
    rarity = Rarity.Epic
    
    stats {
        health(10.0)
        defense(20.0)
        mana(10.0)
    }
}