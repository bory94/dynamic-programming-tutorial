package com.bory.dynamicprogrammingtutorial.number

fun sumOfNaturalNumbers(max: Int): Int {
    if (max <= 1) return max

    return sumOfNaturalNumbers(max - 1) + max
}

fun main() {
    println(sumOfNaturalNumbers(5))
    println(sumOfNaturalNumbers(10))
    println(sumOfNaturalNumbers(25))
    println(sumOfNaturalNumbers(100))
}