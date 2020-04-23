//https://leetcode.com/problems/maximum-subarray/

import java.lang.Integer.max

class MaximumSubarray {

    fun maxSubArray(nums: IntArray): Int {
        return calculateAnswer(0, nums.size - 1, nums).ans
    }

    private fun calculateAnswer(l: Int, r: Int, nums: IntArray): Data {
        val mid = (l + r) / 2
        if (l == r)
            return Data(
                prefSum = nums[l],
                suffSum = nums[l],
                ans = nums[l],
                sum = nums[l]
            )
        return combineData(calculateAnswer(l, mid, nums), calculateAnswer(mid + 1, r, nums))
    }

    private fun combineData(l: Data, r: Data): Data {
        val res = Data()
        res.sum = l.sum + r.sum
        res.prefSum = max(l.prefSum, l.sum + r.prefSum)
        res.suffSum = max(r.suffSum, r.sum + l.suffSum)
        res.ans = max(max(l.ans, r.ans), l.suffSum + r.prefSum)
        return res
    }

    inner class Data(
        var prefSum: Int = 0,
        var suffSum: Int = 0,
        var sum: Int = 0,
        var ans: Int = 0
    )
}