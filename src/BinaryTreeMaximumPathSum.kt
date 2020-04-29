//https://leetcode.com/problems/binary-tree-maximum-path-sum/

import basicClasses.TreeNode
import kotlin.math.max

class BinaryTreeMaximumPathSum {
    var ans = Integer.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null)
            return 0
        val t = dfs(root)
        return max(ans, t)
    }

    private fun dfs(v: TreeNode): Int {
        var tempSum = v.`val`
        if (v.left != null && v.right != null) {
            val left = dfs(v.left!!)
            val right = dfs(v.right!!)
            ans = max(ans, left + right + v.`val`)
            tempSum = max(tempSum, v.`val` + max(left, right))
        } else if (v.right != null) {
            tempSum = max(tempSum, v.`val` + dfs(v.right!!))
        } else if (v.left != null) {
            tempSum = max(tempSum, v.`val` + dfs(v.left!!))
        }
        ans = max(ans, tempSum)
        return tempSum
    }
}