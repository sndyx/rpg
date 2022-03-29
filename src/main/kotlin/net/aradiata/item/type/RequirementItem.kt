package net.aradiata.item.type

import net.aradiata.item.Item

interface RequirementItem : Item {
    
    val requirements: ItemRequirements
    
}

data class ItemRequirements(
    val requiredAgility: Int? = null,
    val requiredStrength: Int? = null,
    val requiredWisdom: Int? = null
)