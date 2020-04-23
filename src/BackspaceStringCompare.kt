//https://leetcode.com/problems/backspace-string-compare/

import java.lang.Integer.max

class BackspaceStringCompare {
    fun backspaceCompare(S: String, T: String): Boolean {
        var i = S.length - 1
        var j = T.length - 1
        var s = 0
        var t = 0
        while (true) {
            i = getCombinableIndex(S, i, 0)
            j = getCombinableIndex(T, j, 0)
            if (i < 0 || j < 0)
                break
            if (S[i] != T[j])
                return false
            i--
            j--
        }
        return i < 0 && j < 0
    }

    private fun getCombinableIndex(cur: String, i: Int, s: Int): Int {
        var I = i
        var S = s
        if (I < 0 || (cur[I] != '#' && s == 0))
            return max(-1, I)
        while (I >= 0 && cur[I] == '#') {
            S++
            I--
        }
        while (I >= 0 && S > 0 && cur[I] != '#') {
            I--
            S--
        }
        return getCombinableIndex(cur, I, S)
    }
}