package com.bory.dynamicprogrammingtutorial.sum

fun howSum(
    targetNum: Int,
    values: IntArray,
    memo: MutableMap<Int, IntArray?> = mutableMapOf()
): IntArray? {
    if (memo.containsKey(targetNum)) {
        return memo[targetNum]
    }

    if (targetNum == 0) return intArrayOf()
    if (targetNum < 0) return null

    for (n in values) {
        val resultArr = howSum(targetNum - n, values, memo)
        if (resultArr != null) {
            memo[targetNum] = intArrayOf(*resultArr, n)
            return memo[targetNum]
        }
    }

    memo[targetNum] = null
    return null
}

fun main() {
    logHowSumCase(7, intArrayOf(2, 3))
    logHowSumCase(7, intArrayOf(5, 3, 4, 7))
    logHowSumCase(7, intArrayOf(2, 4))
    logHowSumCase(8, intArrayOf(2, 3, 5))
    logHowSumCase(300, intArrayOf(7, 14))
}

fun logHowSumCase(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                howSum(targetSum, values)?.joinToString(",")
    )
}