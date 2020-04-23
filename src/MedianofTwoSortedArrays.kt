//https://leetcode.com/problems/median-of-two-sorted-arrays/

class MedianofTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size = nums1.size + nums2.size
        var res = 0.0
        var (i, j) = arrayOf(0, 0)
        while (i < nums1.size && j < nums2.size) {
            val cur = if (nums1[i] < nums2[j]) nums1[i++] else nums2[j++]
            res += safeGetMedianBySize(i + j, cur, size)
        }
        while (i < nums1.size) {
            res += safeGetMedianBySize(i + j + 1, nums1[i++], size)
        }
        while (j < nums2.size) {
            res += safeGetMedianBySize(i + j + 1, nums2[j++], size)
        }
        return res.takeIf { size % 2 == 1 } ?: res / 2.0
    }

    fun safeGetMedianBySize(id: Int, value: Int, size: Int): Int {
        return value.takeIf { id == size / 2 + size % 2 || id == size / 2 + 1 } ?: 0
    }
}