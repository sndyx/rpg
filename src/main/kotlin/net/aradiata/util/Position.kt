package net.aradiata.util

import net.aradiata.Plugin
import org.bukkit.Location
import org.bukkit.util.BoundingBox

fun location(x: Int, y: Int, z: Int): Location = Location(Plugin.world, x.toDouble(), y.toDouble(), z.toDouble())

fun boundingBox(x1: Int, y1: Int, z1: Int, x2: Int, y2: Int, z2: Int) = BoundingBox(
    x1.toDouble(), y1.toDouble(), z1.toDouble(), x2.toDouble(), y2.toDouble(), z2.toDouble()
)