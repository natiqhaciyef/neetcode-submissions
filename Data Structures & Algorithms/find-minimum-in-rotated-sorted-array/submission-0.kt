class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 0) return -1
        if(nums.size == 1) return nums[0]
        if(nums[nums.size - 1] >= nums[0]) return nums[0]

        var start = 0
        var end = nums.size

        var min = nums[0]

        // [4,5,0,1,2,3]
        while(start < end) {
            val mid = (start + end)/ 2

            when {
                nums[mid] <= min -> {
                    min = nums[mid]
                    if(mid > 0 && nums[mid - 1] > nums[mid]) 
                        return nums[mid]
                    else 
                        end = mid
                }

                nums[mid] > min -> {
                    start = mid
                }
            }
        }

        return min
    }
}
