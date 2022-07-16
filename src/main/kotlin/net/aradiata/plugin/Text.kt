package net.aradiata.plugin

import net.aradiata.Config

fun String.colored(): String =
    replace(Regex("&([0-9a-fA-Fkl-oL-OrKL-OR])"), "§$1")


fun MutableList<String>.addWrappingText(text: String) {
    val words = text.split(' ')
    var lastColor = 'f'
    var line = ""
    words.forEach { word ->
        var i = 0
        var actualLength = 0
        while (i < word.length) {
            if (word[i] == '§') {
                lastColor = word[i + 1]
                i += 2
            } else {
                actualLength++
                i++
            }
        }
        if (actualLength > Config.lineLength) {
            add(line)
            add("§$lastColor$word")
        } else if (line.length + actualLength > Config.lineLength) {
            add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }
        
    }
    add(line)
}