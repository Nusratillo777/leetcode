//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import basicClasses.TreeNode

class ConstructBinaryTreefromPreorderandInorder {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        val head = TreeNode(preorder[0])
        for (i in 1 until preorder.size) {
            val temp = TreeNode(preorder[i])
            var cur = head
            while (true) {
                if (saveGetItemId(preorder[i], inorder) < saveGetItemId(cur.`val`, inorder)) {
                    if (cur.left != null) {
                        cur = cur.left!!
                    } else {
                        cur.left = temp
                        break
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right!!
                    } else {
                        cur.right = temp
                        break
                    }
                }
            }
        }
        return head
    }

    fun saveGetItemId(value: Int, array: IntArray): Int {
        return array.indexOf(value)
    }
}