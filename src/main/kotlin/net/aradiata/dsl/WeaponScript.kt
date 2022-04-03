package net.aradiata.dsl

import net.aradiata.item.Item
import net.aradiata.item.Weapon
import net.aradiata.item.WeaponStat
import net.aradiata.item.WeaponStatType
import net.aradiata.item.type.ItemRequirements
import net.aradiata.utility.toScriptSource
import java.nio.file.Path
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

@KotlinScript(
    fileExtension = "weapon.kts",
    compilationConfiguration = WeaponCompilationConfiguration::class,
    evaluationConfiguration = WeaponEvaluationConfiguration::class
)
abstract class WeaponScript

object WeaponCompilationConfiguration : ScriptCompilationConfiguration({
    implicitReceivers(WeaponDelegate::class)
})

class WeaponEvaluationConfiguration(
    private val delegate: WeaponDelegate
) : ScriptEvaluationConfiguration({
    implicitReceivers(delegate)
})

fun runWeaponScript(path: Path): Result<Item> {
    val delegate = WeaponDelegate()
    runCatching {
        BasicJvmScriptingHost().eval(
            path.toScriptSource(),
            WeaponCompilationConfiguration,
            WeaponEvaluationConfiguration(delegate)
        )
    }.onSuccess {
        return Result.success(delegate.toItem())
    }.onFailure {
        return Result.failure(it)
    }
    return Result.failure(Exception()) // Impossible to get to
}

class WeaponDelegate : BaseRequirementDelegate() {
    
    private val weaponStats = WeaponStatsScope()
    
    fun stats(block: WeaponStatsScope.() -> Unit) {
        weaponStats.block()
    }
    
    override fun convertToItem(): Item {
        checkValuesAssigned()
        return Weapon(
            id!!,
            name!!,
            rarity!!,
            description,
            ItemRequirements(requirements.level, requirements.agility, requirements.strength, requirements.wisdom),
            weaponStats.stats.map { WeaponStat(WeaponStatType.values()[it.type.ordinal], it.value, it.chance) })
    }

}

class WeaponStatsScope {

    var suppressMeleeAttacks: Boolean = true
    val stats = mutableListOf<WeaponStatDelegate>()
    
    fun suppressMeleeAttacks() {
        suppressMeleeAttacks = true
    }
    
    fun magic(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Magic, value)
        stats.add(stat)
        return stat
    }
    
    fun ranged(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Ranged, value)
        stats.add(stat)
        return stat
    }
    fun melee(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.Melee, value)
        stats.add(stat)
        return stat
    }
    
    fun attackSpeed(value: Double): WeaponStatDelegate {
        val stat = WeaponStatDelegate(WeaponStatTypeDelegate.AttackSpeed, value)
        stats.add(stat)
        return stat
    }

}

class WeaponStatDelegate(val type: WeaponStatTypeDelegate, val value: Double) {
    
    var chance: Double = 100.0
    
    infix fun chance(value: Double) {
        chance = value
    }
    
}

enum class WeaponStatTypeDelegate {
    
    Melee,
    Magic,
    Ranged,
    AttackSpeed;
    
}