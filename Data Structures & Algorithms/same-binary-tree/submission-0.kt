/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null) return true
        if((p == null) xor (q == null)) return false

        val list1 = mutableListOf<Int>()
        val queue1 = ArrayDeque<TreeNode>()
        queue1.add(p) 

        while(queue1.size > 0) {
            val current = queue1.removeFirst()
            list1.add(current!!.`val`)

            if(current?.left != null)
                queue1.add(current!!.left!!)

            if(current?.right != null) {
                if(current?.left == null)
                    queue1.add(TreeNode(-111))
                queue1.add(current!!.right!!)
            }               
        }

        val list2 = mutableListOf<Int>()
        val queue2 = ArrayDeque<TreeNode>()
        queue2.add(q) 

        while(queue2.size > 0) {
            val current = queue2.removeFirst()
            list2.add(current!!.`val`)

            if(current?.left != null)
                queue2.add(current!!.left!!)

            if(current?.right != null)  {
                if(current?.left == null)
                    queue2.add(TreeNode(-111))
                queue2.add(current!!.right!!)
            }              
        }

        if(list1.size != list2.size) return false

        var count = 0
        while(count < list1.size) {
            val current1 = list1[count]
            val current2 = list2[count]
            if(current1 != current2) return false

            count += 1
        }

        return true
    }
}
