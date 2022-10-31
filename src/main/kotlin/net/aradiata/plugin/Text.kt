package net.aradiata.plugin

fun String.colored(): String =
    replace(Regex("&([0-9a-fA-Fkl-oL-OrKL-OR])"), "§$1")

fun manaBar(mana: Int): String {
    val builder = StringBuilder("\uE001")
    builder.append(when (mana) {
        0 -> '\uE105'
        1 -> '\uE104'
        else -> '\uE103'
    }).append("\uE000")
    repeat(mana / 2 - 1) {
        builder.append('\uE100').append('\uE000')
    }
    when (mana) {
        20 -> builder.append('\uE106').append('\uE000')
        19 -> builder.append('\uE107').append('\uE000')
        else -> {
            if (mana % 2 == 1) builder.append('\uE101').append("\uE000")
            repeat((20 - mana) / 2 - if (mana == 0) 2 else 1) {
                builder.append('\uE102').append('\uE000')
            }
            builder.append('\uE108')
        }
    }
    return builder.toString()
}