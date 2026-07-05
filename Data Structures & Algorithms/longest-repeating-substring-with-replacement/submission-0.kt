class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freqMap = mutableMapOf<Char, Int>()

        var l = 0
        var max = 0
        for(r in s.indices) {
            val ch = s[r]
            val current = freqMap.getOrDefault(ch, 0)
            freqMap[ch] = current + 1

            var freqMax = freqMap.values.max()
            while(r - l + 1 - freqMax > k) {
                val prevCh = s[l]
                l += 1
                val prev = freqMap.getOrDefault(prevCh, 0)
                freqMap[prevCh] = prev - 1 
            }

            max = maxOf(max, r - l + 1)
        }

        return max
    }
}
