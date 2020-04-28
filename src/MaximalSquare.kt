//https://leetcode.com/problems/maximal-square/

import kotlin.math.min
import kotlin.math.max

class MaximalSquare {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty())
            return 0
        val dp = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size) { 0 }
        }
        var ans = 0
        for (i in matrix.indices) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1
                ans = 1
            }
        }
        for (j in matrix[0].indices) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1
                ans = 1
            }
        }
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + min(dp[i][j - 1], min(dp[i - 1][j], dp[i - 1][j - 1]))
                    ans = max(ans, dp[i][j] * dp[i][j])
                }
            }
        }
        return ans
    }
}