/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode>()

        var root = head
        while(root != null) {
            list.add(root)
            root = root.next
        }

        if(list.size == 1 && n == 1) return null
        list.removeAt(list.size - n)

        var copyHead = ListNode(list[0].`val`)
        var temp: ListNode? = copyHead
        var counter = 1
        while(counter < list.size) {
            temp?.next = ListNode(list[counter].`val`)
            temp = temp?.next
            counter += 1
        }

        return copyHead
    }
}
