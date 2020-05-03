import basicClasses.TreeNode

class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        return dfs(root, arr, 0)
    }

    fun dfs(root: TreeNode?, arr: IntArray, index: Int): Boolean {
        if (arr.size == index - 1 && root?.left == null && root?.right == null && root?.`val` == arr[index]) {
            return true
        }
        if (root == null || index >= arr.size || arr[index] != root.`val`)
            return false
        return dfs(root.left, arr, index + 1).or(dfs(root.right, arr, index + 1))
    }
}