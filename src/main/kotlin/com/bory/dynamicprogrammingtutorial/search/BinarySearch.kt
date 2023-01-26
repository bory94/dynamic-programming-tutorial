package com.bory.dynamicprogrammingtutorial.search

fun binarySearch(numbers: IntArray, findingValue: Int, l: Int = 0, r: Int = numbers.size - 1): Int {
    if (l > r) return -1

    val mid = (l + r) / 2

    if (numbers[mid] == findingValue) return mid

    if (findingValue < numbers[mid]) {
        return binarySearch(numbers, findingValue, l, mid - 1)
    }

    return binarySearch(numbers, findingValue, mid + 1, r)
}

fun main() {
    println(binarySearch(intArrayOf(1, 5, 2, 7, 2, 9).sortedArray(), 5))
    println(binarySearch(intArrayOf(1, 3, 2, 7, 2, 9).sortedArray(), 5))
}