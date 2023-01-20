package com.bory.dynamicprogrammingtutorial.word

fun countConstructWithTabulation(targetString: String, values: Array<String>): Int {
    val targetLength = targetString.length
    val table = Array<Int>(targetLength + 1) { 0 }
    table[0] = 1

    for (i in table.indices) {
        val currentSubstring = targetString.substring(i)
        if (table[i] == 0) continue

        for (value in values) {
            if (currentSubstring.isEmpty()) break

            val valueLength = value.length
            if (i + valueLength > targetLength) continue
            if (!currentSubstring.startsWith(value)) continue

            table[i + valueLength] += table[i]
        }
    }

    return table[targetLength]
}

fun main() {
    logCountConstructWithTabulation("abcdef", arrayOf("ab", "cd", "ef", "abc", "def"))
    logCountConstructWithTabulation("purple", arrayOf("purp", "p", "ur", "le", "purpl"))
    logCountConstructWithTabulation("purple", arrayOf("purp", "p", "ur", "e", "le", "purpl"))
    logCountConstructWithTabulation(
        "aaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
        arrayOf("a", "aa", "aaa", "b", "bb", "bbb", "bbbb", "abc", "def", "abcdefg")
    )
    logCountConstructWithTabulation(
        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
        )
    )
}

fun logCountConstructWithTabulation(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            countConstructWithTabulation(
                targetString,
                values
            )
        }"
    )
}