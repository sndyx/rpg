package net.aradiata.script

import net.aradiata.item.Axe
import kotlin.properties.Delegates
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "pickaxe.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
abstract class AxeFile : ItemFile<Axe>() {
    
    var speed: Int by Delegates.notNull()
    var power: Int by Delegates.notNull()
    
    override fun build(id: String) = Axe(
        id, model, name, rarity, description, events, speed, power
    )
    
}