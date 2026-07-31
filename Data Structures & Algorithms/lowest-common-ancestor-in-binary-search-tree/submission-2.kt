/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var current = root 

        if(p == null || q == null) return root

        while(current != null) {

            if(current!!.`val` > p!!.`val` && current!!.`val` > q!!.`val`) {
                current = current.left
            }else if(current!!.`val` < p!!.`val` && current!!.`val` < q!!.`val`){
                current = current.right
            }else{
                return current
            }
        }
        return current
    }
}
