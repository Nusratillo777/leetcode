//https://leetcode.com/problems/increasing-triplet-subsequence/

class IncreasingTripletSubsequence {

    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3)
            return false
        var f = Integer.MAX_VALUE
        var s = f
        for (n in nums) {
            if (n > s)
                return true
            else if (n <= f)
                f = n
            else
                s = n
        }
        return false
    }
}