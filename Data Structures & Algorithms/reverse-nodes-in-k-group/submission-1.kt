/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val result = ListNode(0)
        var temp = result

        var root = head
        while(root != null) {
            val nodes = mutableListOf<ListNode>()
            var counter = 0

            while(root != null && counter < k) {
                val current = root!!
                root = root.next
                current.next = null
                
                nodes.add(current)
                counter += 1
            }

            if(nodes.size < k) {
                for(node in nodes){
                    temp.next = node
                    temp = temp.next!!
                }
            }else{
                for(i in nodes.size - 1 downTo 0){
                    val node = nodes[i]

                    temp.next = node
                    temp = temp.next!!
                }
            }

        }

        return result.next
    }
}
