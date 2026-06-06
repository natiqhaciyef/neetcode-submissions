class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        var answer = IntArray(n) { 0 }

        var total = 1
        val zeroIndex = mutableListOf<Int>()

        for(i in nums.indices) {
            val num = nums[i]
            if(num != 0)
                total *= num
            else
                zeroIndex.add(i)
        }

        return if(zeroIndex.size > 1){
             answer
        } else if(zeroIndex.size == 1) {
            answer[zeroIndex[0]] = total
            answer
        }else {
            for(i in nums.indices) {
                val num = nums[i]
                answer[i] = total/num
            }

            answer
        }
    }
}
