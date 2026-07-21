/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val listNode = ListNode(0)
        var root = listNode

        //list1.`val`
        //list2.`val`
        //list3.`val`
        // hansi minimumdursa onu set ele ve nextini kecir

        while(lists.any { it != null }) {
            var temp: ListNode? = null
            var index = -1
            
            for(i in lists.indices) {
                val list = lists[i]

                if(temp == null) {
                    temp = list
                    index = i
                }else{
                    if(list != null && temp!!.`val` > list!!.`val`) {
                        temp = list
                        index = i
                    }
                }
            }

            if(temp != null){
                root.next = ListNode(temp!!.`val`)
                root = root.next!!
                lists[index] = temp?.next
            }
        }

        return listNode.next
    }
}
