class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val n = nums1.size
        val m = nums2.size
        val total = n + m
        val half = (total + 1) / 2

        var left = 0
        var right = n

        while (left <= right) {
            val mid = left + (right - left) / 2
            val remainMid = half - mid

            val nums1LeftPart = if (mid > 0) nums1[mid - 1] else Int.MIN_VALUE
            val nums1RightPart = if (mid < n) nums1[mid] else Int.MAX_VALUE

            val nums2LeftPart = if (remainMid > 0) nums2[remainMid - 1] else Int.MIN_VALUE
            val nums2RightPart = if (remainMid < m) nums2[remainMid] else Int.MAX_VALUE

            if (nums1LeftPart <= nums2RightPart && nums2LeftPart <= nums1RightPart) {
                if (total % 2 == 1) {
                    return maxOf(nums1LeftPart, nums2LeftPart).toDouble()
                }

                val leftMax = maxOf(nums1LeftPart, nums2LeftPart)
                val rightMin = minOf(nums1RightPart, nums2RightPart)
                return (leftMax + rightMin) / 2.0
            } 
            else if (nums1LeftPart > nums2RightPart) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return 0.0
    }
}
