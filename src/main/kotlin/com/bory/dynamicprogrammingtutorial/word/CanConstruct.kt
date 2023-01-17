package com.bory.dynamicprogrammingtutorial.word

fun canConstruct(
    targetString: String,
    values: Array<String>,
    memo: MutableMap<String, Boolean> = mutableMapOf()
): Boolean {
    if (memo.containsKey(targetString)) {
        return memo[targetString]!!
    }

    if (targetString.isEmpty()) {
        return true
    }

    for (value in values) {
        if (!targetString.startsWith(value)) {
            continue
        }

        val suffix = targetString.substring(value.length)
        val result = canConstruct(suffix, values, memo)

        if (result) {
            memo[targetString] = true
            return true
        }
    }
    memo[targetString] = false
    return false
}


fun main() {
    logCanConstruct("helloworld", arrayOf("hello", "world"))
    logCanConstruct("helloworldhelloworld", arrayOf("hello", "world"))
    logCanConstruct("hellowsworld", arrayOf("hello", "world"))
    logCanConstruct("hello-world", arrayOf("hello", "world"))
    logCanConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
    logCanConstruct(
        "abcfdaefb",
        arrayOf(
            "a", "b", "c", "d", "e", "f"
        )
    )
    logCanConstruct(
        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
            "e", "ee", "eee", "eeee", "eeeee", "eeeeee"
        )
    )
}

fun logCanConstruct(targetString: String, values: Array<String>) {
    println(
        "targetString[$targetString], values[${values.joinToString(",")}] ::: ${
            canConstruct(
                targetString,
                values
            )
        }"
    )
}