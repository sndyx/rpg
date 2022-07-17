package net.aradiata.item

interface Axe : Tool {

    override fun writeDetails(lore: MutableList<String>) {
        buildToolLore(lore, "Axe")
    }

}