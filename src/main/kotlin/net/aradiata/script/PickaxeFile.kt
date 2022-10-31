package net.aradiata.script

import net.aradiata.item.Pickaxe
import kotlin.properties.Delegates
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "pickaxe.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
abstract class PickaxeFile : ItemFile<Pickaxe>() {
    
    var speed: Int by Delegates.notNull()
    var power: Int by Delegates.notNull()
    
    override fun build(id: String) = Pickaxe(
        id, model, name, rarity, description, events, speed, power
    )
    
}