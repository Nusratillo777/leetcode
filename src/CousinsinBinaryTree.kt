//https://leetcode.com/problems/cousins-in-binary-tree/

import basicClasses.TreeNode

class CousinsinBinaryTree {
    var depthOfX = 0
    var depthOfY = 0
    var parentOfX: TreeNode? = null
    var parentOfY: TreeNode? = null

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        getDepth(null, root, 0, x, y)
        return depthOfX == depthOfY && parentOfX != parentOfY
    }

    fun getDepth(parent: TreeNode?, currentNode: TreeNode?, currentDepth: Int, x: Int, y: Int) {
        if (currentNode == null)
            return
        if (currentNode.`val` == x) {
            depthOfX = currentDepth
            parentOfX = parent
        }
        if (currentNode.`val` == y) {
            depthOfY = currentDepth
            parentOfY = parent
        }
        getDepth(currentNode, currentNode.left, currentDepth + 1, x, y)
        getDepth(currentNode, currentNode.right, currentDepth + 1, x, y)
    }
}