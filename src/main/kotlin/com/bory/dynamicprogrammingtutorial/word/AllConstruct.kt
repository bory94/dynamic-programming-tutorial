package com.bory.dynamicprogrammingtutorial.word

fun allConstruct(
    targetString: String,
    values: Array<String>,
    memo: MutableMap<String, Array<Array<String>>> = mutableMapOf()
): Array<Array<String>> {
    if (memo.containsKey(targetString)) {
        return memo[targetString]!!
    }

    if (targetString.isEmpty()) {
        return arrayOf(arrayOf())
    }

    val result = mutableListOf<Array<String>>()
    for (value in values) {
        if (!targetString.startsWith(value)) {
            continue
        }

        val suffix = targetString.substring(value.length)
        val subResult = allConstruct(suffix, values, memo)

        if (subResult.isNotEmpty()) {
            result.addAll(
                subResult.map { arrayOf(value, *it) }
            )
        }
    }

    memo[targetString] = result.toTypedArray()
    return memo[targetString]!!
}

fun main() {
    logAllConstruct("abcdef", arrayOf("ab", "cd", "ef", "abc", "def"))
    logAllConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl"))
    logAllConstruct(
        "aaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
        arrayOf("a", "aa", "aaa", "b", "bb", "bbb", "bbbb", "abc", "def", "abcdefg")
    )
    logAllConstruct(
        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
        )
    )

    logAllConstruct("aaaaaaaaaaaaaaaaaaaaaaaa", arrayOf("aa", "aaa"))
    logAllConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))
}

fun logAllConstruct(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            allConstruct(targetString, values)
                .joinToString(" ||| ") {
                    it.joinToString(",")
                }
        }"
    )
}