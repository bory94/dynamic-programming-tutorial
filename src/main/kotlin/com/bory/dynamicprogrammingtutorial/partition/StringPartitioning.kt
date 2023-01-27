package com.bory.dynamicprogrammingtutorial.partition

fun partitionString(value: String): IntArray {
    val lastIndexMap = mutableMapOf<Char, Int>()
    value.chars().mapToObj { i -> i.toChar() }
        .forEach { c ->
            if (!lastIndexMap.containsKey(c)) lastIndexMap[c] = value.lastIndexOf(c)
        }

    val resultList = mutableListOf<Int>()

    var size = 0
    var end = 0

    val charArray = value.toCharArray()
    for (i in charArray.indices) {
        val c = charArray[i]
        val currentLastIndex = lastIndexMap[c]!!

        if (currentLastIndex > end) {
            end = currentLastIndex
        }

        size++

        if (i >= end) {
            resultList.add(size)
            size = 0
            end = 0
        }
    }


    return resultList.toIntArray()
}

fun main() {
    val result1 = partitionString("ababcbacadefegdehijhklij")
    println("[${result1.joinToString(",")}]")

    val result2 = partitionString("eccbbbbdec")
    println("[${result2.joinToString(",")}]")
}