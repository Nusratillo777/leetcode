//https://leetcode.com/problems/longest-common-subsequence/

import kotlin.math.max

class LongestCommonSubsequence {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val N = max(text1.length, text2.length)
        val dp = arrayOf(
            IntArray(N) { 0 },
            IntArray(N) { 0 }
        )
        text1.forEachIndexed { index1, c1 ->
            var MX = 0
            text2.forEachIndexed { index2, c2 ->
                if (c1 == c2) {
                    dp[index1 % 2][index2] = MX + 1
                }
                MX = max(MX, dp[(index1 + 1) % 2][index2])
                dp[index1 % 2][index2] = max(dp[(index1 + 1) % 2][index2], dp[index1 % 2][index2])
            }
        }
        var ans = 0
        for (i in 0 until N) {
            ans = max(ans, dp[(text1.length - 1) % 2][i])
        }
        return ans
    }
}