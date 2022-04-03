package net.aradiata.dsl

import net.aradiata.item.ItemRequirements

abstract class RequirementItemDelegate : ItemDelegate() {
    
    val requirements = RequirementsScope()
    
    fun requirements(block: RequirementsScope.() -> Unit) {
        requirements.block()
    }
    
}

class RequirementsScope {
    
    var level: Int? = null
    var agility: Int? = null
    var strength: Int? = null
    var wisdom: Int? = null
    
    fun build(): ItemRequirements {
        return ItemRequirements(level, agility, strength, wisdom)
    }
    
}