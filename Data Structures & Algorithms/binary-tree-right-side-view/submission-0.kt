/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if(root == null) return listOf()
        
        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        var count = 1
        queue.add(root!!)
        
        while(queue.size > 0) {
            var current = queue.removeFirst()
            count -= 1

            if(current.left != null) {
                queue.add(current.left!!)
            }

            if(current.right != null) {
                queue.add(current.right!!)
            }
            
            if(count == 0) {
                result.add(current.`val`)
                count = queue.size
            }
        }

        return result
    }


}
