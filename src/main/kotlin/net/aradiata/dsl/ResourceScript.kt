package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Resource
import kotlin.script.experimental.annotations.KotlinScript

@Delegate(ResourceDelegate::class)
@KotlinScript(fileExtension = "resource.kts")
abstract class ResourceScript

class ResourceDelegate : ItemDelegate() {
    
    override fun toItem(): Item = Resource(
        id!!,
        texId!!,
        name!!,
        rarity!!,
        description
    )
    
}