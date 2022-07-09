package net.aradiata.item

interface Bundle {

    fun next(): Item

    fun next(n: Int): List<Item> = List(n) { next() }

}