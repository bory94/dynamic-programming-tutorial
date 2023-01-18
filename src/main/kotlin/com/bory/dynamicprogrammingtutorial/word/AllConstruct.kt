package com.bory.dynamicprogrammingtutorial.word

class ConstructResult(
    val found: Boolean, val constructions: Array<String>
)

fun allConstruct(targetString: String, values: Array<String>): Array<Array<String>> {
    return subAllConstruct(targetString, values)
        .filter { it.found }
        .map { it.constructions }
        .map { it.reverse(); it }
        .toTypedArray()
}

fun subAllConstruct(
    targetString: String,
    values: Array<String>,
    memo: MutableMap<String, List<ConstructResult>> = mutableMapOf()
): List<ConstructResult> {
    if (memo.containsKey(targetString)) {
        return memo[targetString]!!
    }

    if (targetString.isEmpty()) {
        return listOf(ConstructResult(true, arrayOf()))
    }

    val result = mutableListOf<ConstructResult>()

    for (value in values) {
        if (!targetString.startsWith(value)) {
            continue
        }

        val suffix = targetString.substring(value.length)
        val resultList = subAllConstruct(suffix, values, memo)

        result.addAll(
            resultList.filter { it.found }
                .map { cResult ->
                    ConstructResult(true, arrayOf(*cResult.constructions, value))
                }
        )
    }

    memo[targetString] = if (result.isEmpty()) {
        listOf(ConstructResult(false, arrayOf()))
    } else result

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
}

fun logAllConstruct(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            allConstruct(
                targetString,
                values
            ).map {
                it.joinToString(",")
            }.joinToString(" ||| ")
        }"
    )
}