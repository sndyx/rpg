package net.aradiata.item.type

import net.aradiata.item.Pickaxe
import net.aradiata.item.Rarity

object StonkPickaxe : Pickaxe {
    
    override val configId: String = "stonk_pickaxe"
    override val id: Int = 9
    override val name: String = "Stonk Pickaxe"
    override val rarity: Rarity = Rarity.Legendary
    override val description: String = "LOL DO YOU GET THE JOKE !!! lol so its funny because lol stonk is a meme where a villagr is standing in front of a graph pointing in the upwards direction implying that" +
            " assets are being gained. That plays into the name of this pickaxe because it is a stone pickaxe which is one letter off from 'stonk pickaxe' LOL get it the letter is replaced and therefor this" +
            " pickaxe increases drops by a giant margin!!! It really takes somebody who is quite involved in r/memes to understand this one so your welcome for the explanation. Girls definitely wouldnt get  this" +
            " joke."
    
    override val power: Int = 20
    override val speed: Int = 50
    override val dropIncrease: Int = 1000
    
}