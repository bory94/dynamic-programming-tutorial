package com.bory.dynamicprogrammingtutorial.sum

fun bestSumWithTabulation(targetSum: Int, values: IntArray): IntArray {
    val table = Array<IntArray?>(targetSum + 1) { null }
    table[0] = intArrayOf()

    for (i in 0..targetSum) {
        if (table[i] == null) continue

        for (value in values) {
            if (i + value > targetSum) continue

            val asisArray = table[i + value]
            val newArray = intArrayOf(*table[i]!!, value)

            table[i + value] =
                if (asisArray == null || asisArray.size > newArray.size) newArray else asisArray
        }
    }

    return table[targetSum] ?: intArrayOf()
}

fun main() {
    logBestSumWithTabulation(7, intArrayOf(1, 2, 3))
    logBestSumWithTabulation(7, intArrayOf(5, 3, 4, 7))
    logBestSumWithTabulation(7, intArrayOf(2, 4))
    logBestSumWithTabulation(8, intArrayOf(2, 3, 5))
    logBestSumWithTabulation(8, intArrayOf(1, 2, 3, 5, 8))
    logBestSumWithTabulation(15, intArrayOf(1, 2, 3, 5, 8))
    logBestSumWithTabulation(200, intArrayOf(6, 7, 14))
    logBestSumWithTabulation(400, intArrayOf(6, 7, 14))
}

fun logBestSumWithTabulation(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                bestSumWithTabulation(targetSum, values).joinToString(",")
    )
}