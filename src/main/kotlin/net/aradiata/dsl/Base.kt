package net.aradiata.dsl

fun item(type: Type.Resource, configuration: ResourceScope.() -> Unit) {

}

fun item(type: Type.Weapon, configuration: WeaponScope.() -> Unit) {

}

fun item(type: Type.Armor, configuration: ArmorScope.() -> Unit) {

}

fun item(type: Type.Consumable, configuration: WeaponScope.() -> Unit) {

}