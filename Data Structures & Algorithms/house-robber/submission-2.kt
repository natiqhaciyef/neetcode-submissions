class Solution {
    private var memo: IntArray = intArrayOf()
    fun rob(nums: IntArray): Int {
        if(nums.size == 0) return 0
        if(nums.size == 1) return nums[0]
        if(nums.size == 2) return maxOf(nums[0], nums[1]) 
        
        memo = IntArray(nums.size)
        memo[0] = nums[0]
        memo[1] = nums[1]

        val first = recurse(nums, memo, 2)
        val second = recurse(nums, memo, 1)

        return maxOf(memo[nums.size - 1], memo[nums.size - 2])
    }   

    private fun recurse(nums: IntArray, memo: IntArray, current: Int){
        if(current == 1) {
            memo[current] = maxOf(memo[current], memo[current - 1])
            recurse(nums, memo, current + 1)
        }else{
            if(current == nums.size) return 

            val num = nums[current]
            val first = num + memo[current - 2]
            val second = memo[current - 1]

            memo[current] = maxOf(memo[current], maxOf(first, second))
            recurse(nums, memo, current + 1)

        }
    }
}
