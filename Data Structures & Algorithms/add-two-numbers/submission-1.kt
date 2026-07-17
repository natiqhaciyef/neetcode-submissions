/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null) return l2
        if(l2 == null) return l1

        var temp = 0
        val current = l1!!.`val` + l2!!.`val`
        temp = current / 10

        val head = ListNode(current % 10)
        var node = head

        var node1 = l1?.next
        var node2 = l2?.next
        while(node1 != null || node2 != null) {
            var num1 = 0
            var num2 = 0

            if(node1 != null) {
                num1 = node1.`val`
                node1 = node1.next
            }

            if(node2 != null) {
                num2 = node2.`val`
                node2 = node2.next
            }

            val sum = num1 + num2 + temp
            temp = sum / 10
            node.next = ListNode(sum % 10)
            node = node.next!!
        }

        if(temp > 0) {
            node.next = ListNode(temp)
        }

        return head
    }
}
