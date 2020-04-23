//https://leetcode.com/problems/add-two-numbers/

import basicClasses.ListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        if (l1 == null || l2 == null)
            return null
        var t = l1.`val` + l2.`val`
        val ans = ListNode(t % 10)
        t /= 10
        var temp = ans
        l1 = l1.next
        l2 = l2.next
        while (l1 != null || l2 != null || t > 0) {
            if (l1 != null) {
                t += l1.`val`
                l1 = l1.next
            }
            if (l2 != null) {
                t += l2.`val`
                l2 = l2.next
            }
            temp.next = ListNode(t % 10)
            temp = temp.next!!
            t /= 10
        }
        return ans
    }
}
