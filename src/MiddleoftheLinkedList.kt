//https://leetcode.com/problems/middle-of-the-linked-list/

import basicClasses.ListNode

class MiddleoftheLinkedList {

    fun middleNode(head: ListNode?): ListNode? {
        var listSize = 0
        var tempHead = head
        while (tempHead != null) {
            listSize++
            tempHead = tempHead.next
        }
        tempHead = head
        for (i in 0 until listSize / 2)
            tempHead = tempHead?.next
        return tempHead
    }
}