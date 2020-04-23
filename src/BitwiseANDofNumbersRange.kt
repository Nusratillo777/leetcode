//https://leetcode.com/problems/bitwise-and-of-numbers-range/

import kotlin.math.pow

class BitwiseANDofNumbersRange {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        val bitsM = Integer.toBinaryString(m)
        val bitsN = Integer.toBinaryString(n)
        if (bitsM.length != bitsN.length)
            return 0
        var ans = 0
        bitsM.forEachIndexed { index, c ->
            val temp: Int = (2.0).pow(bitsM.length - index - 1).toInt()
            if (n - m + 1 <= temp && c == '1' && bitsN[index] == '1')
                ans += temp
        }
        return ans
    }
}