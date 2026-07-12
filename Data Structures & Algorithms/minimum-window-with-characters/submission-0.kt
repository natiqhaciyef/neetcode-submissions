class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""

        val mapT = mutableMapOf<Char, Int>()
        for (ch in t) {
            mapT[ch] = mapT.getOrDefault(ch, 0) + 1
        }

        val mapS = mutableMapOf<Char, Int>()

        var start = 0 
        var end = 0

        var minLen = Integer.MAX_VALUE 
        var result = ""
        var counter = 0

        while (end < s.length) {
            val currentChar = s[end]
            
            mapS[currentChar] = mapS.getOrDefault(currentChar, 0) + 1
            if (mapT.containsKey(currentChar) && mapS[currentChar]!! <= mapT[currentChar]!!) {
                counter += 1
            }

            while (counter == t.length) {
                val currentWindow = end - start + 1
                if (currentWindow < minLen) {
                    minLen = currentWindow
                    result = s.substring(start, end + 1)
                }
                
                val leftChar = s[start]
                mapS[leftChar] = mapS[leftChar]!! - 1
                
                if (mapT.containsKey(leftChar) && mapS[leftChar]!! < mapT[leftChar]!!) {
                    counter -= 1
                }
                
                start += 1
            }

            end += 1
        }        

        return result
    }
}
