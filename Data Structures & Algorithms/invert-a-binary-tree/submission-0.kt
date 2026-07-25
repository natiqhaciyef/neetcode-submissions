/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        return dfs(root)
    }

    private fun dfs(node: TreeNode?): TreeNode? {
        if(node?.left != null) {
            dfs(node?.left!!)
        }

        if(node?.right != null) {
            dfs(node?.right!!)
        }

        val left = node?.left
        val right = node?.right

        node?.left = right
        node?.right = left      

        return node  
    }
}
