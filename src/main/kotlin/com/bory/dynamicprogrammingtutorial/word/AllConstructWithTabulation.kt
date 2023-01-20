package com.bory.dynamicprogrammingtutorial.word

fun allConstructWithTabulation(targetString: String, values: Array<String>): Array<Array<String>> {
    val targetLength = targetString.length
    val table = Array<Array<Array<String>>?>(targetLength + 1) { null }
    table[0] = arrayOf(arrayOf<String>())

    for (i in table.indices) {
        if (table[i] == null) continue

        val currentSubstring = targetString.substring(i)
        for (value in values) {
            val valueLength = value.length
            if (!currentSubstring.startsWith(value)) continue

            val newCombinations =
                arrayOf(
                    *table[i]!!.map { arrayOf(*it, value) }.toTypedArray()
                )

            table[i + valueLength] =
                if (table[i + valueLength] == null) newCombinations
                else arrayOf(*newCombinations, *table[i + valueLength]!!)
        }
    }

    return table[targetLength] ?: arrayOf()
}

fun main() {
    logAllConstructWithTabulation("abcdef", arrayOf("ab", "cd", "ef", "abc", "def"))
    logAllConstructWithTabulation("purple", arrayOf("purp", "p", "ur", "le", "purpl"))
//    logAllConstructWithTabulation(
//        "aaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
//        arrayOf("a", "aa", "aaa", "b", "bb", "bbb", "bbbb", "abc", "def", "abcdefg")
//    )
//    logAllConstructWithTabulation(
//        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
//            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
//        )
//    )

    logAllConstructWithTabulation("aaaaaaaaaaaaaaaaaaaaaaaa", arrayOf("aa", "aaa"))
    logAllConstructWithTabulation("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))
}

fun logAllConstructWithTabulation(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            allConstructWithTabulation(targetString, values)
                .joinToString(" ||| ") {
                    it.joinToString(",")
                }
        }"
    )
}