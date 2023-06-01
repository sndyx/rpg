package net.aradiata.util

import net.md_5.bungee.api.ChatColor
import java.awt.Color

fun ChatColor(r: Int, g: Int, b: Int): ChatColor = ChatColor.of(Color(r, g, b))

val NO_OUTLINE = ChatColor(78, 92, 36)