package net.aradiata.utility

fun String.colored(): String = replace(Regex("&([0-9a-fA-FklmnorKLMNOR])"), "§$1")

fun writeWrappingText(list: MutableList<String>, text: String) {
    var lastColorCode = 'f'
    var count = 0
    var i = 0
    val builder = StringBuilder()
    while (i < text.length) {
        if (text[i] == '§' && text[i + 1].toString().matches(Regex("[0-9a-fA-FklmnorKLMNOR]"))) {
            builder.append(text[i]).append(text[i + 1])
            lastColorCode = text[i + 1]
            i += 2
        } else {
            builder.append(text[i])
            count++
            i++
        }
        if (count == 30) {
            list.add(builder.toString())
            builder.clear().append('§').append(lastColorCode)
            count = 0
        }
    }
    list.add(builder.toString())
}
