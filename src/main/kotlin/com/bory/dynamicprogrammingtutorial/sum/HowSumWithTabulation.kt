package com.bory.dynamicprogrammingtutorial.sum

fun howSumWithTabulation(targetSum: Int, values: IntArray): IntArray {
    val table = Array<IntArray?>(targetSum + 1) { null }
    table[0] = intArrayOf()
    
    for (i in 0..targetSum) {
        if (table[i] == null) continue

        for (value in values) {
            if (i + value > targetSum) continue

            table[i + value] = intArrayOf(*table[i]!!, value)
            if (table[targetSum] != null) return table[targetSum]!!
        }
    }

    return intArrayOf()
}

fun main() {
    logHowSumCaseWithTabulation(7, intArrayOf(2, 3))
    logHowSumCaseWithTabulation(7, intArrayOf(5, 3, 4, 7))
    logHowSumCaseWithTabulation(7, intArrayOf(2, 4))
    logHowSumCaseWithTabulation(8, intArrayOf(2, 3, 5))
    logHowSumCaseWithTabulation(8, intArrayOf(2, 3, 5, 8))
    logHowSumCaseWithTabulation(200, intArrayOf(6, 7, 14))
}

fun logHowSumCaseWithTabulation(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                howSumWithTabulation(targetSum, values).joinToString(",")
    )
}