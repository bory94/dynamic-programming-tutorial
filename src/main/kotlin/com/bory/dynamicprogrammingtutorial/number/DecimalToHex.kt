package com.bory.dynamicprogrammingtutorial.number

fun decimalToHex(n: Int, hexValue: String = ""): String {
    if (n == 0) return "0x$hexValue"

    val remains = n % 16
    val remainsValue = if (remains >= 10) {
        (remains + 55).toChar().toString()
    } else {
        remains.toString()
    }

    return decimalToHex(n / 16, "$remainsValue$hexValue")
}

fun main() {
    println(decimalToHex(1))
    println(decimalToHex(9))
    println(decimalToHex(10))
    println(decimalToHex(11))
    println(decimalToHex(12))
    println(decimalToHex(13))
    println(decimalToHex(14))
    println(decimalToHex(15))
    println(decimalToHex(16))
    println(decimalToHex(17))
    println(decimalToHex(32))
    println(decimalToHex(48))
}
