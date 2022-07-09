package net.aradiata.item

interface Resource : Item {

    override fun writeDetails(lore: MutableList<String>) { /* Ignore */ }

}