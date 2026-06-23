class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableSetOf<List<Int>>()

        for(i in nums.indices) {
            var l = i + 1
            var r = nums.size - 1
            if(i > 0 && nums[i] == nums[i - 1]) continue

            while(l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                if(sum < 0)
                    l += 1
                else if(sum > 0)
                    r -= 1
                else{
                    result.add(listOf<Int>(nums[i], nums[l], nums[r]))
                    r -= 1
                }
            }
        }

        return result.toList()
    }
}
