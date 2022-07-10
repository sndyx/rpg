package net.aradiata.item

interface Bundle {

    fun next(): List<Item>

    fun next(n: Int): List<Item> = List(n) { next() }.flatten()

}