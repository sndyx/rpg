package net.aradiata.dsl

abstract class BaseRequirementDelegate : BaseItemDelegate() {
    
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
    
}