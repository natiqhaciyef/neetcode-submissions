/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private val list = mutableListOf<Int>()
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if(root == null) return 0
        
        dfs(root!!, k)
        return if(list.size == 0) 0 else list[list.size - 1]
    }

    private fun dfs(node: TreeNode, remaining: Int) {
        if(list.size == remaining) {
            return
        }

        if(node.left == null && node.right == null) {
            list.add(node.`val`)
            return
        }

        if(node.left != null) {
            dfs(node.left!!, remaining)
        }

        if(list.size == remaining) {
            return
        }

        list.add(node.`val`)

        if(list.size == remaining) {
            return
        }

        if(node.right != null) {
            dfs(node.right!!, remaining)
        }
    }
}
