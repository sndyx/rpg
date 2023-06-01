package net.aradiata.math

fun fmod(dividend: Double, divisor: Double): Double {
    return (dividend % divisor + divisor) % divisor
}

fun fmod1(dividend: Double): Double = fmod(dividend, 1.0)