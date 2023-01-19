package com.bory.dynamicprogrammingtutorial.fibonacci

fun findFibonacciWithTabulation(n: Int): Long {
    val fibonacciNumbers = Array<Long>(n + 1) { 0 }
//    fibonacciNumbers[0] = 0
    fibonacciNumbers[1] = 1
    for (i in 2..n) {
        fibonacciNumbers[i] = fibonacciNumbers[i - 2] + fibonacciNumbers[i - 1]
    }

    return fibonacciNumbers[n]
}

fun main() {
    println(findFibonacciWithTabulation(6))
    println(findFibonacciWithTabulation(7))
    println(findFibonacciWithTabulation(8))
    println(findFibonacciWithTabulation(50))
}