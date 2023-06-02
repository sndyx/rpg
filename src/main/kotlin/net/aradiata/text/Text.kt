package net.aradiata.text

import net.md_5.bungee.api.ChatColor
import java.awt.Color

fun ChatColor(r: Int, g: Int, b: Int): ChatColor = ChatColor.of(Color(r, g, b))

val NO_OUTLINE = ChatColor(78, 92, 36)

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
        if (actualLength > 30) {
            add(line)
            add("§$lastColor$word")
        } else if (line.length + actualLength > 30) {
            add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }

    }
    add(line)
}