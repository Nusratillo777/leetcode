//https://leetcode.com/problems/longest-palindromic-substring/

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String?): String {
        if (s == null || s.length == 0)
            return ""
        var start = 0
        var end = 0
        for (i in 0 until s.length) {
            val len1 = getMaxPolindromeSize(s, i, i)
            val len2 = getMaxPolindromeSize(s, i, i + 1)
            val len = Math.max(len1, len2)
            if (end - start + 1 < len) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    private fun getMaxPolindromeSize(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right
        while (L >= 0 && R < s.length && s[L] == s[R]) {
            R++
            L--
        }
        return R - L - 1
    }
}