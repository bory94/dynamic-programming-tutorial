package com.bory.dynamicprogrammingtutorial.word

fun canConstructWithTabulation(targetString: String, values: Array<String>): Boolean {
    val targetLength = targetString.length
    val table = Array<Boolean>(targetLength + 1) { false }
    table[0] = true

    for (i in table.indices) {
        if (!table[i]) continue
        for (value in values) {
            val valueLength = value.length
            if (i + valueLength > targetLength) continue
            
            val currentSubstring = targetString.substring(i)
            if (!currentSubstring.startsWith(value)) continue

            table[i + valueLength] = true
            if (table[targetLength]) return true
        }
    }

    return false
}

fun main() {
    logCanConstructWithTabulation("helloworld", arrayOf("hello", "world"))
    logCanConstructWithTabulation("helloworldhelloworld", arrayOf("hello", "world"))
    logCanConstructWithTabulation("hellowsworld", arrayOf("hello", "world"))
    logCanConstructWithTabulation("hello-world", arrayOf("hello", "world"))
    logCanConstructWithTabulation("abcde", arrayOf("ab", "cd", "a", "bcde"))
    logCanConstructWithTabulation(
        "skateboard",
        arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar")
    )
    logCanConstructWithTabulation(
        "abcfdaefb",
        arrayOf("a", "b", "c", "d", "e", "f")
    )
    logCanConstructWithTabulation(
        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
        )
    )
}

fun logCanConstructWithTabulation(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            canConstructWithTabulation(
                targetString,
                values
            )
        }"
    )
}