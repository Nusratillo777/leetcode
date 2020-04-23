//https://leetcode.com/problems/move-zeroes/

class MoveZeroes {

    fun moveZeroes(nums: IntArray): Unit {
        var zeroCount = 0
        nums.forEachIndexed { index, num ->
            if (num == 0)
                zeroCount++
            else
                nums[index - zeroCount] = num
        }
        for (i in 0 until zeroCount)
            nums[nums.size - i - 1] = 0
    }
}