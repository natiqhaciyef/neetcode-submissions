class Solution {
    private val list = mutableListOf<List<Int>>()
    
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        backtrack(0, candidates, mutableListOf(), target)
        return list
    }

    private fun backtrack(start: Int, nums: IntArray, arr: MutableList<Int>, target: Int) {
        if(target < 0){
            return
        }

        if(target == 0) {
            list.add(ArrayList(arr))
        }
        
        for(i in start until nums.size) {
            val num = nums[i]
            
            if(i > start && num == nums[i - 1]){
                continue
            }
            
            arr.add(num)
            backtrack(i + 1, nums, arr, target - num)
            arr.remove(num)
        }
    }
}
