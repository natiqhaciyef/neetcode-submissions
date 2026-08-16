class Solution {
    private val list = mutableListOf<List<Int>>()
    
    fun permute(nums: IntArray): List<List<Int>> {
        backtrack(nums, mutableSetOf(), mutableListOf())
        return list
    }

    private fun backtrack(nums: IntArray, visited: MutableSet<Int>, arr: MutableList<Int>){
        if(arr.size == nums.size) {
            list.add(ArrayList(arr))
            return
        }

        for(num in nums) {
            if(num in visited) continue
            arr.add(num)
            visited.add(num)
            
            backtrack(nums, visited, arr)
            
            arr.remove(num)
            visited.remove(num)
        }
    }
}
