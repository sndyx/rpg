package net.aradiata.item.impl

import net.aradiata.item.ArmorType
import net.aradiata.item.Rarity
import net.aradiata.item.dsl.armor
import net.aradiata.item.dsl.defense
import net.aradiata.item.dsl.health

val theChestplateOfSomewhatGreatness = armor("the_chestplate_of_somewhat_greatness") {
    
    model = 1
    name = "The Chestplate of (Somewhat) Greatness"
    rarity = Rarity.Rare
    description = "A pretty great chestplate?"
    type = ArmorType.Chestplate
    
    stats {
        defense(300.0)
        health(10.0)
    }
    
}