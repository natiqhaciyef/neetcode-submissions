class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(0, nums, mutableListOf(), result)
        return result
    }

    private fun backtrack(
        start: Int, 
        nums: IntArray, 
        current: MutableList<Int>, 
        result: MutableList<List<Int>>
    ) {
        result.add(ArrayList(current))

        for (i in start until nums.size) {
            current.add(nums[i])
            backtrack(i + 1, nums, current, result)
            current.removeAt(current.size - 1)
        }
    }
}
