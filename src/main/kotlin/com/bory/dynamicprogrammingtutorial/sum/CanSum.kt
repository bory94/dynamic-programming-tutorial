package com.bory.dynamicprogrammingtutorial.sum

fun canSum(
    targetSum: Int,
    values: IntArray,
    memo: MutableMap<Int, Boolean> = mutableMapOf()
): Boolean {
    if (memo.containsKey(targetSum)) {
        return memo[targetSum]!!
    }
    if (targetSum == 0) {
        return true
    }

    if (targetSum < 0) {
        return false
    }

    for (n in values) {
        val result = canSum(targetSum - n, values, memo)
        if (result) {
            memo[targetSum] = true
            return true
        }
    }

    memo[targetSum] = false
    return false
}

fun main() {
    logCanSumCase(7, intArrayOf(2, 3, 4))
    logCanSumCase(9, intArrayOf(2, 4, 8))
    logCanSumCase(8, intArrayOf(2, 3, 5))
    logCanSumCase(22, intArrayOf(2, 3, 8))
    logCanSumCase(33, intArrayOf(2, 3, 8))
    logCanSumCase(300, intArrayOf(7, 14))
    logCanSumCase(3093, intArrayOf(6, 7, 14))
}

fun logCanSumCase(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                "${canSum(targetSum, values)}"
    )
}