class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }

        return set.size != nums.size 
    }
}
