class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val n = nums.size
        val leftArr = IntArray(n)
        val rightArr = IntArray(n)

        var total = 0
        for(i in nums.indices) {
            total += nums[i]
        }

        var temp = 0
        for(i in nums.indices) {
            leftArr[i] = temp
            rightArr[i] = total - temp - nums[i]

            if(leftArr[i] == rightArr[i]) return i
            temp += nums[i]
        }

        return -1
    }
}
