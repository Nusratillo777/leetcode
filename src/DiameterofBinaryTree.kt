//https://leetcode.com/problems/diameter-of-binary-tree/

import basicClasses.TreeNode
import kotlin.math.max

class Data(
    var ans: Int = 0,
    var deepCount: Int = 0
)

class DiameterofBinaryTree {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return dfs(root).ans
    }

    private fun dfs(v: TreeNode?): Data {
        if (v == null)
            return Data()
        val tree = Data()
        val l = dfs(v.left)
        val r = dfs(v.right)
        tree.ans = max(max(l.ans, r.ans), l.deepCount + r.deepCount)
        tree.deepCount = max(l.deepCount, r.deepCount) + 1
        return tree
    }
}