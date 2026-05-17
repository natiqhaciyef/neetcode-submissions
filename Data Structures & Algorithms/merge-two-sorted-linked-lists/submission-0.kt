/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var head1 = list1
    var head2 = list2

    var result: ListNode? = null
    if (head2 == null) return head1
    if (head1 == null) return head2

    if(head1.`val` > head2.`val`) {
        result = ListNode(head2.`val`)
        head2 = head2.next
    }else{
        result = ListNode(head1.`val`)
        head1 = head1.next
    }

    val holdingHead = result

    while(head1 != null || head2 != null) {
        if (head1 == null){
            result?.next = head2
            break
        }
        
        if (head2 == null){
            result?.next = head1
            break
        }
            
        if(head1.`val` > head2.`val`) {
            result?.next = ListNode(head2.`val`)
            result = result?.next
            head2 = head2.next
        }else{
            result?.next = ListNode(head1.`val`)
            result = result?.next
            head1 = head1.next
        }
    }

    return holdingHead
}
}
