/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
    
        return dfsPostOrder(root) > 0
    }

    private fun dfsPostOrder(root: TreeNode?): Int {
        if(root == null) return 1
        
        val left = dfsPostOrder(root.left)
        if(left == -1) return left

        val right = dfsPostOrder(root.right)
        if(right == -1) return right

        if(abs(left - right) > 1) return -1

        return maxOf(left, right) + 1
    }
}
