package net.aradiata.item

interface Hoe : Tool {

    override fun writeDetails(lore: MutableList<String>) {
        buildToolLore(lore, "Hoe")
    }

}