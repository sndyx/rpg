package net.aradiata.ui

import kotlin.math.*


interface UIComponent {

    fun render(): RenderResult

    companion object {

        fun offset(x: Int): String {
            var n = x
            return buildString {
                while (n != 0) {
                    // Find the highest power of two below n
                    val pow = 2.0.pow(floor(log2(abs(n.toDouble())))).toInt() * n.sign
                    // Fucked xor operation, find nearest power
                    n -= if ((n > pow * 1.5).xor(n < 0)) {
                        (pow * 2).also { append(powChar(pow * 2)) }
                    } else {
                        (pow).also { append(powChar(pow)) }
                    }
                }
            }
        }

        private fun powChar(n: Int): Char {
            val log = log2(abs(n.toDouble())).toInt()
            return if (n > 0) '\uF800' + log else '\uF810' + log
        }

    }

}

