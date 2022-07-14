package newv.aradiata.plugin

import newv.aradiata.Config

fun String.colored(): String =
    replace(Regex("(?!(?:(\\\\){2})*\\\\)&([a-f\\d])")) { "§${it.groupValues[0]}" }

fun writeWrappingText(list: MutableList<String>, text: String) {
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
            list.add(line)
            list.add("§$lastColor$word")
        } else if (line.length + actualLength > Config.lineLength) {
            list.add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }
        
    }
    list.add(line)
}