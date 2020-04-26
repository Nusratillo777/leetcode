//https://leetcode.com/problems/jump-game/

import kotlin.math.max

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val jumps = BooleanArray(nums.size) { false }
        jumps[0] = true
        var currentMaxJump = nums[0]
        nums.forEachIndexed { index, i ->
            if (jumps[index]) {
                if (index + i < nums.size)
                    jumps[index + i] = true
                currentMaxJump = max(currentMaxJump, index + i)
            }
            jumps[index] = index <= currentMaxJump
        }
        return jumps[nums.size - 1]
    }
}