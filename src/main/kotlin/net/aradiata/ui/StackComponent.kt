package net.aradiata.ui

import kotlin.math.*
import kotlin.reflect.KClass

abstract class StackComponent<T : UIComponent>(
    val components: MutableList<T>
) : UIComponent {

    constructor() : this(mutableListOf())

    open fun addComponent(component: T) {
        components.add(component)
    }

    open fun removeComponent(type: KClass<*>) {
        components.removeIf { c: T -> c::class == type }
    }

    open fun hasComponent(type: KClass<*>): Boolean = components.any { it::class == type }

}