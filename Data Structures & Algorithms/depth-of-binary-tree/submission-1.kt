/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        // bfs needed
        if(root == null) return 0

        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)

        var cycle = 1
        var count = 0

        while(queue.size > 0) {
            val current = queue.removeFirst()

            if(current.left != null) {
                queue.add(current.left!!)
            }

            if(current.right != null) {
                queue.add(current.right!!)
            }

            cycle -= 1

            if(cycle == 0) {
                count += 1
                cycle = queue.size
            }
        }

        return count
    }
    
    
}
