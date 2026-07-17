class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(num in nums) {
            val hashIndex = abs(num) - 1
            if(nums[abs(num) - 1] < 0) return abs(num)
            nums[abs(num) - 1] *= -1
        }

        return -1
    }
}
