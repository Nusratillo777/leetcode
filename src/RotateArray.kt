//https://leetcode.com/problems/rotate-array/

class RotateArray {

    fun rotate(nums: IntArray, k: Int) {
        var k = k
        var count = 0
        k %= nums.size
        var start = 0
        while (count < nums.size) {
            var current = start
            var prev = nums[start]
            do {
                val next = (current + k) % nums.size
                val temp = nums[next]
                nums[next] = prev
                prev = temp
                current = next
                count++
            } while (start != current)
            start++
        }
    }
}