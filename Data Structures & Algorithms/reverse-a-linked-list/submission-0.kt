/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // 1->2->3->4

        var node: ListNode? = null
        var temp = head
        while (temp != null) {
            val next = node
            node = ListNode(temp.`val`)
            node.next = next

            temp = temp.next
        }

        return node
    }
}
