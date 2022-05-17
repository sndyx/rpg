package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.utility.jvmScriptingHost
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Delegate(val delegate: KClass<*>)

inline fun <reified T : Any> runScript(path: Path): Result<Item> {
    
    val delegate: KClass<*> = (T::class.java.annotations
        .find { it is Delegate } as Delegate).delegate
    
    val host = jvmScriptingHost {
        configuration {
            import("net.aradiata.dsl.*")
            import("net.aradiata.item.Rarity.*")
        }
    }
    
    val content = "${delegate.simpleName}().apply {${path.readText()}}.run { checkProperties(); toItem() }"
    
    return host.eval(content.byteInputStream())
    
}