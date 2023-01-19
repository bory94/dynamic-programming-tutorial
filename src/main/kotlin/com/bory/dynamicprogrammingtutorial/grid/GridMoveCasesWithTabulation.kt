package com.bory.dynamicprogrammingtutorial.grid

fun findGridMoveCasesWithTabulation(
    m: Int, n: Int
): Long {
    if (m == 0 || n == 0) {
        return 0
    }

    val table = Array<Array<Long>>(m) { Array(n) { 0 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 || j == 0) {
                table[i][j] = 1
                continue
            }

            table[i][j] = table[i - 1][j] + table[i][j - 1]
        }
    }

//    val maxLength = table[m - 1][n - 1].toString().length

//    println("[")
//    for (i in 0 until m) {
//        for (j in 0 until n) {
//            print("${paddedValue(table[i][j], maxLength)}, ")
//        }
//        println()
//    }
//    println("]")

    return table[m - 1][n - 1]
}

//fun Any.paddedValue(maxLength: Int) = toString().padStart(maxLength, ' ')

fun main() {
    logGridMoveCaseWithTabulation(0, 0)
    logGridMoveCaseWithTabulation(1, 1)
    logGridMoveCaseWithTabulation(2, 3)
    logGridMoveCaseWithTabulation(3, 2)
    logGridMoveCaseWithTabulation(3, 3)
    logGridMoveCaseWithTabulation(5, 6)
    logGridMoveCaseWithTabulation(18, 18)
    logGridMoveCaseWithTabulation(100, 100)
}

fun logGridMoveCaseWithTabulation(m: Int, n: Int) {
    println("$m X $n = ${findGridMoveCasesWithTabulation(m, n)}")
}