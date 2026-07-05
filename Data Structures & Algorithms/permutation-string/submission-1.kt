class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        

        val map = mutableMapOf<Char, Int>()
        for(ch in s1) {
            val current = map.getOrDefault(ch, 0)
            map[ch] = current + 1
        }

        var start = 0
        var end = s1.length - 1
        val counterMap = mutableMapOf<Char, Int>()

        for(i in 0..end) {    
            val ch = s2[i]
            val current = counterMap.getOrDefault(ch, 0)
            counterMap[ch] = current + 1
        }

        while(end < s2.length) {            
            if(counterMap.matchesIgnoringZeros(map)) return true

            val startCh = s2[start]
            val startCurrent = counterMap.getOrDefault(startCh, 0)
            counterMap[startCh] = startCurrent - 1

            if(end + 1 < s2.length) {                
                val endCh = s2[end + 1]
                val endCurrent = counterMap.getOrDefault(endCh, 0)
                counterMap[endCh] = endCurrent + 1   
            }

            start += 1
            end += 1

            println(counterMap)
        }


        return false
    }

    fun Map<Char, Int>.matchesIgnoringZeros(other: Map<Char, Int>): Boolean {
        // Check that every non-zero entry in this map matches the other map
        for ((key, value) in this) {
            if (value != 0 && other.getOrDefault(key, 0) != value) return false
        }
        // Check that the other map doesn't contain non-zero keys that this map missed
        for ((key, value) in other) {
            if (value != 0 && this.getOrDefault(key, 0) != value) return false
        }
        return true
    }
}
