package net.aradiata.item.impl

import net.aradiata.item.ArmorType
import net.aradiata.item.Rarity
import net.aradiata.item.dsl.armor
import net.aradiata.item.dsl.defense
import net.aradiata.item.dsl.health

val theHelmetOfGreatness = armor("the-helmet-of-greatness") {
    
    model = 1
    name = "The Helmet of Greatness"
    rarity = Rarity.Common
    description = "A pretty great helmet"
    type = ArmorType.Helmet
    
    stats {
        defense(10000.0)
        health(5.0)
    }
    
}