class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // number, Pair(index, frequency)
        val map = mutableMapOf<Int, Int>()

        for(i in nums.indices) {
            val num = nums[i]

            val current = map.getOrDefault(num, 0)
            map[num] = current + 1
        }

        val answer = IntArray(k)
        val sortedMap = map.entries.sortedByDescending { it.value }

        var count = 0
        for((key, value) in sortedMap) {
            if(count == k) break

            answer[count] = key
            count += 1
        }

        return answer
    }
}
