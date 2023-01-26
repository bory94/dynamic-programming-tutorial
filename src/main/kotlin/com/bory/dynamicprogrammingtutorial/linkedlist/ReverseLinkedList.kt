package com.bory.dynamicprogrammingtutorial.linkedlist

class Node(val n: Int) {
    var next: Node? = null
}

class LinkedList {
    private var head: Node? = null

    fun push(newData: Int) {
        val newNode = Node(newData)
        newNode.next = head
        head = newNode
    }

    fun reverse() {
        if (head == null) return

        head = reverseNode(head!!)
    }

    private fun reverseNode(node: Node?): Node? {
        if (node?.next == null) return node

        val reversed = reverseNode(node.next)
        node.next!!.next = node
        node.next = null

        return reversed
    }

    override fun toString(): String {
        return buildString {
            append("[")
            var currentNode = head
            while (currentNode != null) {
                append(currentNode.n)
                currentNode = currentNode.next
                if (currentNode != null) append(",")
                else break
            }
            append("]")
        }
    }
}

fun main() {
    val linkedList = LinkedList()
    linkedList.push(1)
    linkedList.push(2)
    linkedList.push(3)
    linkedList.push(4)
    linkedList.push(5)

    println(linkedList.toString())

    linkedList.reverse()

    println(linkedList.toString())

}