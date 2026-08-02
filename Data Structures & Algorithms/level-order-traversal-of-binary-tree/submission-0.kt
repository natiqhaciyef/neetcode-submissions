/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()
        val list = mutableListOf<List<Int>>()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var count = 1

        var tempList = mutableListOf<Int>()
        while(queue.size > 0) {
            val current = queue.removeFirst()
            tempList.add(current.`val`)

            if(current.left != null){
                queue.add(current.left!!)
            }

            if(current.right != null){
                queue.add(current.right!!)
            }

            count -= 1
            
            if(count == 0) {
                count = queue.size
                list.add(tempList)
                tempList = mutableListOf()
            }
        }

        return list
    }
}
