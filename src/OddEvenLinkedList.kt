//https://leetcode.com/problems/odd-even-linked-list/

import basicClasses.ListNode

class OddEvenLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {
        var head: ListNode? = head ?: return null
        val dummyOddHead = ListNode(0)
        val dummyEvenHead = ListNode(0)
        var oddNodes: ListNode? = dummyOddHead
        var evenNodes: ListNode? = dummyEvenHead
        var id = 1
        while (head != null) {
            if (id % 2 == 1) {
                oddNodes!!.next = ListNode(head.`val`)
                oddNodes = oddNodes.next
            } else {
                evenNodes!!.next = ListNode(head.`val`)
                evenNodes = evenNodes.next
            }
            id++
            head = head.next
        }
        oddNodes!!.next = dummyEvenHead.next
        return dummyOddHead.next
    }
}