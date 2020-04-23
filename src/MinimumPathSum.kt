//https://leetcode.com/problems/minimum-path-sum/

import java.lang.Integer.min

class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty())
            return 0
        val N = grid.size
        val M = grid[0].size
        val dp: Array<IntArray> = Array(N) { IntArray(M) { Int.MAX_VALUE } }
        dp[0][0] = grid[0][0]
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (i > 0)
                    dp[i][j] = min(dp[i - 1][j] + grid[i][j], dp[i][j])
                if (j > 0)
                    dp[i][j] = min(dp[i][j - 1] + grid[i][j], dp[i][j])
            }
        }
        return dp[N - 1][M - 1]
    }
}