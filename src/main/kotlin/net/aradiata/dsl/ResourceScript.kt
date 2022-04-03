package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Resource
import net.aradiata.utility.toScriptSource
import java.nio.file.Path
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

@KotlinScript(
    fileExtension = "resource.kts",
    compilationConfiguration = ResourceCompilationConfiguration::class,
    evaluationConfiguration = ResourceEvaluationConfiguration::class
)
abstract class ResourceScript

object ResourceCompilationConfiguration : ScriptCompilationConfiguration({
    implicitReceivers(ResourceDelegate::class)
})

class ResourceEvaluationConfiguration(
    private val delegate: ResourceDelegate
) : ScriptEvaluationConfiguration({
    implicitReceivers(delegate)
})

fun runResourceScript(path: Path): Result<Item> {
    val delegate = ResourceDelegate()
    runCatching {
        BasicJvmScriptingHost().eval(
            path.toScriptSource(),
            ResourceCompilationConfiguration,
            ResourceEvaluationConfiguration(delegate)
        )
    }.onSuccess {
        return Result.success(delegate.toItem())
    }.onFailure {
        return Result.failure(it)
    }
    return Result.failure(Exception()) // Impossible to get to
}

class ResourceDelegate : BaseItemDelegate() {
    
    override fun convertToItem(): Item {
        return Resource(
            id!!,
            name!!,
            rarity!!,
            description
        )
    }
    
}