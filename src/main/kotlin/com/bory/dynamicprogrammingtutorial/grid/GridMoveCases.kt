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
    logGridMoveCase(1, 1)
    logGridMoveCase(2, 3)
    logGridMoveCase(3, 2)
    logGridMoveCase(3, 3)
    logGridMoveCase(5, 6)
    logGridMoveCase(18, 18)
    logGridMoveCase(100, 100)
}

fun logGridMoveCase(m: Int, n: Int) {
    println("$m X $n = ${findGridMoveCases(m, n)}")
}