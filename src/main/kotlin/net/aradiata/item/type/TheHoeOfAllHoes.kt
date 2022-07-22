package net.aradiata.item.type

import net.aradiata.item.Hoe
import net.aradiata.item.Rarity

object TheHoeOfAllHoes : Hoe {

    override val configId: String = "the_hoe_of_all_hoes"
    override val id: Int = 10
    override val name: String = "Wooden Hoe"
    override val rarity: Rarity = Rarity.Divine
    override val description: String? = "Keeping up with Kardashians"

    override val power: Int = 0
    override val speed: Int = 0
    override val dropIncrease: Int = 20
}