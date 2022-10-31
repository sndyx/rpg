package net.aradiata.script.host

import net.aradiata.script.*
import java.nio.file.Path
import kotlin.io.path.name
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

fun eval(path: Path) {
    val configuration = when (path.name.substringAfter('.')) {
        "resource.kts" -> createJvmCompilationConfigurationFromTemplate<ResourceFile>()
        "weapon.kts" -> createJvmCompilationConfigurationFromTemplate<WeaponFile>()
        "armor.kts" -> createJvmCompilationConfigurationFromTemplate<ArmorFile>()
        "pickaxe.kts" -> createJvmCompilationConfigurationFromTemplate<PickaxeFile>()
        "axe.kts" -> createJvmCompilationConfigurationFromTemplate<AxeFile>()
        else -> error("Unknown file extension")
    }
    BasicJvmScriptingHost().eval(
        path.toFile().toScriptSource(), configuration, null
    )
}