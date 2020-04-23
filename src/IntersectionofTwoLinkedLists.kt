//https://leetcode.com/problems/intersection-of-two-linked-lists/

import basicClasses.ListNode

class IntersectionofTwoLinkedLists {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var dummyA = headA
        var dummyB = headB
        if (headA == null || headB == null)
            return null
        var okA = true
        var okB = true
        while (okA || dummyA != null || okB || dummyB != null) {
            if (okB && dummyB == null) {
                okB = false
                dummyB = headA
            }
            if (okA && dummyA == null) {
                okA = false
                dummyA = headB
            }
            if (dummyA == dummyB)
                return dummyA
            if (dummyA != null)
                dummyA = dummyA.next
            if (dummyB != null)
                dummyB = dummyB.next
        }
        return null
    }
}