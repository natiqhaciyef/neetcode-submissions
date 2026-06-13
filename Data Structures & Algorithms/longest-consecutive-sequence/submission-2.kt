class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var cons = 0
        val map = mutableMapOf<Int, Int>()
        
        for(num in nums) {
            val current = map.getOrDefault(num, 0)
            map[num] = current + 1
        }

        var temp = 0
        for((key, value) in map) {
            var current = key
            while(map[current]!= null) {
                temp += 1
                current += 1 
            }
            cons = max(cons, temp)
            temp = 0
        }

        if(temp > 1) 
            cons = max(cons, temp)

        return cons
    }
}
