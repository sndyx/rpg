package net.aradiata.item

enum class Rarity(val colorCode: Char, val translationKey: String) {

    Common('7', "attribute.item.rarity.common"),
    Uncommon('a', "attribute.item.rarity.uncommon"),
    Rare('9', "attribute.item.rarity.rare"),
    Epic('5', "attribute.item.rarity.epic"),
    Legendary('6', "attribute.item.rarity.legendary"),
    Divine('d', "attribute.item.rarity.divine");

}