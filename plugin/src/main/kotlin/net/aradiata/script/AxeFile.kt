package net.aradiata.script

import net.aradiata.item.Axe
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "pickaxe.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
abstract class AxeFile : ItemFile<Axe>() {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build(id: String) = Axe(
        id, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}