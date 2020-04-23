//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

import basicClasses.TreeNode

class ConstructBinarySearchTreefromPreorderTraversal {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty())
            return null
        val root = TreeNode(preorder[0])
        for (i in 1 until preorder.size) {
            addNode(root, preorder[i])
        }
        return root
    }

    private fun addNode(root: TreeNode, `val`: Int) {
        if (root.`val` > `val`) {
            if (root.left != null) {
                addNode(root.left!!, `val`)
            } else {
                root.left = TreeNode(`val`)
            }
        } else {
            if (root.right != null) {
                addNode(root.right!!, `val`)
            } else {
                root.right = TreeNode(`val`)
            }
        }
    }
}