class Solution {
    private val list = mutableSetOf<List<Int>>(listOf())

    fun subsets(nums: IntArray): List<List<Int>> {
        backtrack(nums)
        return list.toList()
    }

    private fun backtrack(arr: IntArray) {
        if(arr.size == 0) return
        
        val current = arr.toMutableList()
        list.add(current)


        val size = arr.size
        for(i in 0 until size) {
            val num = arr[i]

            current.removeAt(i)
            backtrack(current.toIntArray())
            current.add(i, num)
        }
    }
}
