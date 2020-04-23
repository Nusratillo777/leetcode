//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class RemoveDuplicatesfromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        var ans = 0
        for (i in 1 until nums.size) {
            if (nums[i - 1] == nums[i]) {
                ans++
            } else {
                nums[i - ans] = nums[i]
            }
        }
        return nums.size - ans
    }
}