package com.bory.dynamicprogrammingtutorial.sum

fun howSumWithTabulation(targetSum: Int, values: IntArray): Array<Int> {
    val table = Array(targetSum + 1) { mutableListOf<MutableList<Int>>() }
    table[0].add(mutableListOf(0))


    for (i in 0..targetSum) {
        if (table[i].isEmpty()) continue

        for (value in values) {
            if (i + value > targetSum) {
                continue
            }

            val casesInCell = table[i]
            casesInCell.forEach { case ->
                table[i + value].add(
                    mutableListOf(
                        *(case.filter { it != 0 }.toTypedArray()),
                        value
                    )
                )
            }
            if (table[targetSum].isNotEmpty()) return table[targetSum][0].toTypedArray()
        }
    }

    return arrayOf()
}

fun main() {
    logHowSumCaseWithTabulation(7, intArrayOf(2, 3))
    logHowSumCaseWithTabulation(7, intArrayOf(5, 3, 4, 7))
    logHowSumCaseWithTabulation(7, intArrayOf(2, 4))
    logHowSumCaseWithTabulation(8, intArrayOf(2, 3, 5))
    logHowSumCaseWithTabulation(130, intArrayOf(6, 7, 14))
}

fun logHowSumCaseWithTabulation(targetSum: Int, values: IntArray) {
    println(
        "TargetSum[$targetSum], " +
                "values[${values.joinToString(",")}] ::: " +
                howSumWithTabulation(targetSum, values).joinToString(",")
    )
}