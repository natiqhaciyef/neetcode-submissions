class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var end = nums.size - 1
        var start = 0

        while(start <= end) {
            val mid = (start + end) / 2
            if(nums[mid] == target) return mid

            if(nums[start] <= nums[mid]){
                // start to mid should be sorted
                if(nums[mid] < target || nums[start] > target)
                    start = mid + 1
                else
                    end = mid - 1
            
            }else {
                if(target < nums[mid] || target > nums[end])
                    end = mid - 1
                else
                    start = mid + 1
            }
        }

        return -1
    }
}