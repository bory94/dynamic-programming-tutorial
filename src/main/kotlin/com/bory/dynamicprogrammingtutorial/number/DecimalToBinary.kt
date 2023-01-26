package com.bory.dynamicprogrammingtutorial.number

fun decimalToBinary(n: Int, binValue: String = ""): String {
    if (n == 0) return binValue

    val remains = n % 2

    return decimalToBinary(n / 2, "$remains$binValue")
}

fun main() {
    println(decimalToBinary(24))
    println(decimalToBinary(36))
    println(decimalToBinary(98))
    println(decimalToBinary(1024))
}