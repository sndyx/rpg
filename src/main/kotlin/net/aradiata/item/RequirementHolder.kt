package net.aradiata.item

interface RequirementHolder {
    
    val requirements: ItemRequirements
    
}

data class ItemRequirements(
    val requiredLevel: Int? = null,
    val requiredAgility: Int? = null,
    val requiredStrength: Int? = null,
    val requiredWisdom: Int? = null
)