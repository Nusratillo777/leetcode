class SingleElementinaSortedArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r) / 2
            if (mid + 1 < nums.size && nums[mid] == nums[mid + 1]) {
                if ((mid - l) % 2 == 1)
                    r = mid - 1
                else
                    l = mid + 2
            } else
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    if ((r - mid) % 2 == 1)
                        l = mid + 1
                    else
                        r = mid - 2
                } else
                    return nums[mid]
        }
        return nums[r]
    }
}