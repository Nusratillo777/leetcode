//https://leetcode.com/problems/product-of-array-except-self/

class ProductofArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        var allProduct = 1
        val N = nums.size
        val suf = IntArray(N + 1) { 0 }
        val pref = IntArray(N + 1) { 0 }
        val res = mutableListOf<Int>()
        suf[0] = nums[0]
        pref[N - 1] = nums[N - 1]
        for (i in 1 until N)
            suf[i] = suf[i - 1] * nums[i]
        suf.forEach { print("$it ") }
        for (i in (N - 2) downTo 0)
            pref[i] = pref[i + 1] * nums[i]
        println()
        pref.forEach { print("$it ") }
        println()
        for (i in 0 until N) {
            if (i == 0)
                res.add(pref[i + 1])
            else if (i == N - 1)
                res.add(suf[i - 1])
            else res.add(suf[i - 1] * pref[i + 1])
        }
        return res.toIntArray()
    }
}