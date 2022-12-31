package net.aradiata.plugin

fun String.colored(): String =
    replace(Regex("&([0-9a-fA-Fkl-oL-OrKL-OR])"), "§$1")

val manaBar: Map<Int, String> = List(21) {
    Pair(it, buildManaBar(it))
}.toMap()

private fun buildManaBar(mana: Int): String {
    val builder = StringBuilder()
    builder.append(when (mana) {
        0 -> '\uE105'
        1 -> '\uE104'
        else -> '\uE103'
    }).append("\uE000")
    repeat(mana / 2 - if (mana == 20) 2 else 1) {
        builder.append('\uE100').append('\uE000')
    }
    when (mana) {
        20 -> builder.append('\uE106')
        19 -> builder.append('\uE107')
        else -> {
            if (mana % 2 == 1 && mana != 1) builder.append('\uE101').append("\uE000")
            repeat((20 - mana) / 2 - if (mana == 0) 2 else 1) {
                builder.append('\uE102').append('\uE000')
            }
            builder.append('\uE108')
        }
    }
    return builder.toString()
}