package com.bory.dynamicprogrammingtutorial.word

fun countConstruct(
    targetString: String,
    values: Array<String>,
    memo: MutableMap<String, Int> = mutableMapOf()
): Int {
    if (memo.containsKey(targetString)) {
        return memo[targetString]!!
    }

    if (targetString.isEmpty()) {
        return 1
    }

    var count = 0
    for (value in values) {
        if (!targetString.startsWith(value)) {
            continue
        }

        val suffix = targetString.substring(value.length)
        val subCount = countConstruct(suffix, values, memo)

        count += subCount
    }

    memo[targetString] = count
    return count
}

fun main() {
    logCountConstruct("abcdef", arrayOf("ab", "cd", "ef", "abc", "def"))
    logCountConstruct("purple", arrayOf("purp", "p", "ur", "le", "purpl"))
    logCountConstruct(
        "aaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
        arrayOf("a", "aa", "aaa", "b", "bb", "bbb", "bbbb", "abc", "def", "abcdefg")
    )
    logCountConstruct(
        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
        )
    )
}

fun logCountConstruct(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            countConstruct(
                targetString,
                values
            )
        }"
    )
}