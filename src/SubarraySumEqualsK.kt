//https://leetcode.com/problems/subarray-sum-equals-k/

class SubarraySumEqualsK {

    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.isEmpty())
            return 0
        val sumArray = IntArray(nums.size + 1) { 0 }
        var ans = 0
        sumArray[1] = nums[0]
        for (i in 1 until nums.size)
            sumArray[i + 1] = sumArray[i] + nums[i]
        for (i in 1 until nums.size + 1) {
            for (j in i until nums.size + 1) {
                if (sumArray[j] - sumArray[i - 1] == k)
                    ans++
            }
        }
        return ans
    }
}