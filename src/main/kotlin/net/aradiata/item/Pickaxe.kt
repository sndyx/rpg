package net.aradiata.item

interface Pickaxe : Tool {

    override fun writeDetails(lore: MutableList<String>) {
        buildToolLore(lore, "Pickaxe")
    }
}