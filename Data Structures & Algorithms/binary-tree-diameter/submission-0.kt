/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var maxSum = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {

        dfs(root)
        return maxSum
    }

    private fun dfs(node: TreeNode?): Int {
        if(node == null) return 0
        
        val nodeLeft = dfs(node?.left)
        val nodeRight = dfs(node?.right)

        val total = nodeLeft + nodeRight
        maxSum = maxOf(maxSum, total)

        return maxOf(nodeLeft, nodeRight) + 1
    }
}
