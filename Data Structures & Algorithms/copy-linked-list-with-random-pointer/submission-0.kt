/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if(head == null) return null
        val map = mutableMapOf<Node, Node>()

        var root = head
        while(root != null) {
            val newNode = Node(root.`val`)
            map[root] = newNode
            
            root = root.next
        }

        root = head
        while(root != null) {
            val current = map[root]!!
            
            if(root.next != null)
                current.next = map[root!!.next] ?: Node(root.next!!.`val`)

            if(root.random != null)
                current.random = map[root!!.random] ?: Node(root.random!!.`val`)

            root = root.next
        }

        return map[head!!]
    }
}
