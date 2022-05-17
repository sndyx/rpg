package net.aradiata.item

import java.io.Serializable

interface RequirementHolder : Serializable {
    
    val requirements: ItemRequirements
    
}

data class ItemRequirements(
    val requiredLevel: Int? = null,
    val requiredAgility: Int? = null,
    val requiredStrength: Int? = null,
    val requiredWisdom: Int? = null
) : Serializable