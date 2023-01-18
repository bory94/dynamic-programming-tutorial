package com.bory.dynamicprogrammingtutorial.sum

fun bestSum(
    targetNum: Int,
    values: IntArray,
    memo: MutableMap<Int, IntArray> = mutableMapOf()
): IntArray? {
    if (memo.containsKey(targetNum)) {
        return memo[targetNum]!!
    }

    if (targetNum == 0) return intArrayOf()
    if (targetNum < 0) return null

    var bestArr: IntArray? = null

    for (n in values) {
        val subComposition = bestSum(targetNum - n, values, memo)
        if (subComposition != null && (bestArr?.size ?: Integer.MAX_VALUE) > subComposition.size) {
            bestArr = intArrayOf(*subComposition, n)
            memo[targetNum] = bestArr
        }
    }

    return bestArr
}

fun main() {
    logBestSumCase(7, intArrayOf(5, 3, 4, 7))
    logBestSumCase(8, intArrayOf(2, 3, 5))
    logBestSumCase(8, intArrayOf(1, 4, 5))
    logBestSumCase(100, intArrayOf(1, 2, 5, 25))
}

fun logBestSumCase(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                bestSum(targetSum, values)?.joinToString(",")
    )
}