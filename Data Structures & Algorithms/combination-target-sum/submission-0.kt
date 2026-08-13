class Solution {
    private val list = mutableListOf<List<Int>>()
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        backtrack(0, nums, target, 0, mutableListOf())
        return list
    }

    private fun backtrack(
        startingIndex: Int,
        nums: IntArray, 
        target: Int, 
        current: Int,
        arr: MutableList<Int>
    ) { 
        if(target == current) {
            list.add(ArrayList(arr))
            return
        }

        if(current > target) {
            return
        }

        for(i in startingIndex until nums.size) {
            val num = nums[i]
            
            arr.add(num)
            backtrack(
                i,
                nums,
                target,
                current + num,
                arr
            )
            arr.remove(num)
        }
    }
}
