package com.bory.dynamicprogrammingtutorial.grid

fun findGridMoveCases(
    m: Int,
    n: Int,
    memo: MutableMap<Pair<Int, Int>, Long> = mutableMapOf()
): Long {
    if (memo.containsKey(Pair(m, n))) {
        return memo[Pair(m, n)]!!
    }

    if (m <= 1 || n <= 1) {
        return 1
    }

    memo[Pair(m, n)] = findGridMoveCases(m - 1, n, memo) + findGridMoveCases(m, n - 1, memo)
    return memo[Pair(m, n)]!!
}

fun main() {
    logCase(1, 1)
    logCase(2, 3)
    logCase(3, 2)
    logCase(3, 3)
    logCase(5, 6)
    logCase(18, 18)
    logCase(100, 100)
}

fun logCase(m: Int, n: Int) {
    println("$m X $n = ${findGridMoveCases(m, n)}")
}