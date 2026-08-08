/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        val inorderIndexMap = HashMap<Int, Int>()
        for (i in inorder.indices) {
            inorderIndexMap[inorder[i]] = i
        }

        val root = TreeNode(preorder[0])
        val stack = ArrayDeque<TreeNode>()
        stack.add(root)

        for (i in 1 until preorder.size) {
            val valNew = preorder[i]
            val nodeNew = TreeNode(valNew)
            var top = stack.last()

            val indexOfTop = inorderIndexMap[top.`val`]!!
            val indexOfNew = inorderIndexMap[valNew]!!

            if (indexOfNew < indexOfTop) {
                top.left = nodeNew
            } else {
                var lastPopped = top
                while (stack.isNotEmpty() && indexOfNew > inorderIndexMap[stack.last().`val`]!!) {
                    lastPopped = stack.removeLast() 
                }
                lastPopped.right = nodeNew
            }

            stack.add(nodeNew)
        }

        return root
    }
}
