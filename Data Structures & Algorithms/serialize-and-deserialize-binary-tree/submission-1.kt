/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {

    // Encodes a tree to a single string using preorder traversal
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        buildString(root, sb)
        return sb.toString()
    }

    private fun buildString(node: TreeNode?, sb: StringBuilder) {
        if (node == null) {
            sb.append("#," )
        } else {
            sb.append(node.`val`).append(",")
            buildString(node.left, sb)
            buildString(node.right, sb)
        }
    }

    // Decodes your encoded data to tree
    fun deserialize(data: String): TreeNode? {
        val nodes = ArrayDeque(data.split(","))
        return buildTree(nodes)
    }

    private fun buildTree(nodes: ArrayDeque<String>): TreeNode? {
        if (nodes.isEmpty()) return null

        val valStr = nodes.removeFirst()
        if (valStr == "#" || valStr.isEmpty()) return null

        val root = TreeNode(valStr.toInt())
        root.left = buildTree(nodes)
        root.right = buildTree(nodes)

        return root
    }
}