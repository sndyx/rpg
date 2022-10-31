package net.aradiata.script

import net.aradiata.item.Resource
import kotlin.script.experimental.annotations.KotlinScript

@ItemDsl
@KotlinScript(
    fileExtension = "resource.kts",
    compilationConfiguration = ItemCompilationConfiguration::class
)
class ResourceFile : ItemFile<Resource>() {
    
    override fun build(id: String) = Resource(
        id, model, name, rarity, description, events
    )
    
}