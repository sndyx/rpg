package net.aradiata.script

import net.aradiata.item.Pickaxe
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "pickaxe.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
abstract class PickaxeFile : ItemFile<Pickaxe>() {
    
    var speed: Int? = null
    var power: Int? = null
    
    override fun build(id: String) = Pickaxe(
        id, model!!, name!!, rarity!!, description, events, speed!!, power!!
    )
    
}