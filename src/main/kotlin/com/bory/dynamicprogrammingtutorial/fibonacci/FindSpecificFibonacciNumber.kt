package com.bory.dynamicprogrammingtutorial.fibonacci


fun findFibonacci(n: Long, memo: MutableMap<Long, Long> = mutableMapOf()): Long {
    if (memo.containsKey(n)) {
        return memo[n]!!
    }
    if (n <= 2) {
        return 1
    }

    memo[n] = findFibonacci(n - 2, memo) + findFibonacci(n - 1, memo)
    return memo[n]!!
}

fun main() {
    println(findFibonacci(180))
}