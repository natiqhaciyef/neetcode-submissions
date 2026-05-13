class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // first will number, second will be index
        val map = mutableMapOf<Int, Int>()

        var result = IntArray(2)
        for(i in nums.indices) {
            val num = nums[i]
            val current = map.getOrDefault(target - num, -1)
            
            if(current != -1){
                result[0] = current
                result[1] = i
                return result
            }

            map[num] = i
        }

        return result
    }
}
