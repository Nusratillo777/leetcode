//https://leetcode.com/problems/number-of-islands/

class NumberofIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty())
            return 0
        val N = grid.size
        val M = grid[0].size
        val A = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        var ans = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (!A[i][j] && grid[i][j] == '1') {
                    ans++
                    dfs(i, j, N, M, A, grid)
                }
            }
        }
        return ans
    }

    private fun dfs(i: Int, j: Int, N: Int, M: Int, A: Array<BooleanArray>, grid: Array<CharArray>) {
        if (i < 0 || j < 0 || i >= N || j >= M || grid[i][j] != '1' || A[i][j])
            return
        A[i][j] = true
        dfs(i + 1, j, N, M, A, grid)
        dfs(i - 1, j, N, M, A, grid)
        dfs(i, j + 1, N, M, A, grid)
        dfs(i, j - 1, N, M, A, grid)
    }
}