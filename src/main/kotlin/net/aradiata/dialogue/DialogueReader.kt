package net.aradiata.dialogue

import java.nio.file.Path
import kotlin.io.path.readLines

class DialogueReader(path: Path) {
    
    init {
        var indent = 0
        path.readLines().forEach {
            if (!it.startsWith())
            if (it.startsWith("if "))
            if (it.matches(Regex("\\w+:")))
        }
    }
    
}