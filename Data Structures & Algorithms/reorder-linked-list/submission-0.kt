/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        val list = mutableListOf<Int>()

        var root = head
        while(root != null) {
            list.add(root.`val`)
            root = root?.next
        }

        var isOdd = false
        var point = 0

        root = head 
        while(root != null){
            if(isOdd) {
                root.`val` = list[list.size - 1 - point]
                point += 1
            }else{
                root.`val` = list[point]
            }

            isOdd = !isOdd
            root = root.next
        }

    }
}
