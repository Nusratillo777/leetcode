//https://leetcode.com/problems/min-stack/

import kotlin.math.min

class MinStack() {

    private var currentNode: StackNode? = null

    fun push(x: Int) {
        val tempNode = StackNode(x)
        tempNode.prev = currentNode
        currentNode = tempNode
    }

    fun pop() {
        currentNode = currentNode?.prev
    }

    fun top(): Int {
        return currentNode?.`val` ?: 0
    }

    fun getMin(): Int {
        var tempNode = currentNode
        var minValue = Int.MIN_VALUE
        while (tempNode != null) {
            minValue = min(minValue, tempNode.`val`)
            tempNode = tempNode.prev
        }
        return minValue
    }

    inner class StackNode(
        val `val`: Int,
        var prev: StackNode? = null
    )
}