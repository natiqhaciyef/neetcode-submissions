class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for (num in nums) {
            val hashIndex = abs(num) - 1
            if (nums[hashIndex] < 0) return abs(num)
            nums[hashIndex] *= -1
        }

        return -1
    }
}
