/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        maxGain(root)
        return maxSum
    }

    private fun maxGain(node: TreeNode?): Int {
        if (node == null) return 0

        val leftGain = maxOf(maxGain(node.left), 0)
        val rightGain = maxOf(maxGain(node.right), 0)

        val priceNewPath = node.`val` + leftGain + rightGain
        maxSum = maxOf(maxSum, priceNewPath)

        return node.`val` + maxOf(leftGain, rightGain)
    }
}
