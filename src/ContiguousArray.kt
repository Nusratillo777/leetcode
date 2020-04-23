//https://leetcode.com/problems/contiguous-array/

class ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        if (nums.isEmpty())
            return 0
        val sumArray = IntArray(nums.size + 1) { 0 }
        for (i in 1 until nums.size + 1) {
            sumArray[i] = sumArray[i - 1] + if (nums[i - 1] == 1) 1 else -1
        }
        val hashMap = HashMap<Int, Int>()
        var ans = 0
        for (i in 1 until nums.size + 1) {
            if (sumArray[i] == 0)
                ans = i
            if (hashMap.containsKey(sumArray[i])) {
                if (i - hashMap[sumArray[i]]!! > ans)
                    ans = i - hashMap[sumArray[i]]!!
            } else {
                hashMap[sumArray[i]] = i
            }
        }
        return ans
    }
}