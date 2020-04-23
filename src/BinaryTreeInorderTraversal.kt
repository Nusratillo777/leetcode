//https://leetcode.com/problems/binary-tree-inorder-traversal/

import basicClasses.TreeNode
import java.util.ArrayList

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode): List<Int> {
        val res = ArrayList<Int>()
        dfs(root, res)
        return res
    }

    private fun dfs(v: TreeNode?, ans: MutableList<Int>) {
        if (v == null)
            return
        dfs(v.left, ans)
        ans.add(v.`val`)
        dfs(v.right, ans)
    }
}