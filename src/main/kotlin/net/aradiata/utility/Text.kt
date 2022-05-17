package net.aradiata.utility

fun String.colored(): String = replace(Regex("&([0-9a-fA-Fkl-oL-OrKL-OR])"), "§$1")

const val LINE_LENGTH = 30

fun writeWrappingText(list: MutableList<String>, text: String) {
    val words = text.split(' ')
    var lastColor = 'f'
    var line = ""
    
    words.forEach { word ->
        
        // Find color codes and remove
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
        
        // Check for wrapping
        if (actualLength > LINE_LENGTH) {
            list.add(line)
            list.add("§$lastColor$word")
        } else if (line.length + actualLength > LINE_LENGTH) {
            list.add(line)
            line = "§$lastColor$word "
        } else {
            line += "$word "
        }
        
    }
    // Add last line
    list.add(line)
}
