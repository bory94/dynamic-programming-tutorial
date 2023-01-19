package com.bory.dynamicprogrammingtutorial.sum

fun canSumWithTabulation(targetNum: Int, values: IntArray): Boolean {
    val table = Array<Boolean>(targetNum + 1) { false }
    table[0] = true

    for (i in table.indices) {
        if (!table[i]) continue
        for (value in values) {
            if (i + value > targetNum) continue

            table[i + value] = true
            if (table[targetNum]) return true
        }
    }


//    print("[ ")
//    for (i in 0..targetNum) {
//        print("${table[i]}, ")
//    }
//    println(" ]")

    return false
}

fun main() {
    logCanSumCaseWithTabulation(7, intArrayOf(2, 3, 4))
    logCanSumCaseWithTabulation(7, intArrayOf(2, 4))
    logCanSumCaseWithTabulation(9, intArrayOf(2, 4, 8))
    logCanSumCaseWithTabulation(8, intArrayOf(2, 3, 5))
    logCanSumCaseWithTabulation(22, intArrayOf(2, 3, 8))
    logCanSumCaseWithTabulation(33, intArrayOf(2, 3, 8))
    logCanSumCaseWithTabulation(300, intArrayOf(7, 14))
    logCanSumCaseWithTabulation(3093, intArrayOf(6, 7, 14))
}

fun logCanSumCaseWithTabulation(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                "${canSumWithTabulation(targetSum, values)}"
    )
}