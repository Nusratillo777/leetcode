//https://leetcode.com/problems/single-number/

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        nums.forEach {
            ans = ans.xor(it)
        }
        return ans
    }
}