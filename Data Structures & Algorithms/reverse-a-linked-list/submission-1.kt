/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head

    while (curr != null) {
        // 1. Temporarily store the next node
        val nextTemp = curr.next 
        
        // 2. Reverse the current node's pointer to face backwards
        curr.next = prev 
        
        // 3. Move 'prev' and 'curr' one step forward for the next iteration
        prev = curr
        curr = nextTemp
    }

    // 'prev' will be the new head of the reversed list
    return prev
}
}
