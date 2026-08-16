class Solution {
    private val list = mutableListOf<List<Int>>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        backtrack(nums, 0, mutableListOf())
        return list
    }

    private fun backtrack(nums: IntArray, start: Int, arr: MutableList<Int>) {
        if(start >= nums.size) {
            list.add(ArrayList(arr))
            return 
        }

        for(i in start until nums.size) {
            val num = nums[i]

            if (i > start && num == nums[i - 1]) {
                continue
            }

            arr.add(num)
            backtrack(nums, i + 1, arr)
            arr.remove(num)
        }

        list.add(ArrayList(arr))
    }
}
