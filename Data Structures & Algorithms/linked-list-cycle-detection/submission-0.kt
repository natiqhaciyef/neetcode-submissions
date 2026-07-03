/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        // turtle and hare

        var turtle = head?.next
        var hare = head?.next?.next

        while(turtle != null && hare != null) {
            if(turtle!!.`val` == hare!!.`val`) return true

            turtle = turtle?.next
            hare = hare?.next?.next
        }

        return false
    }
}
