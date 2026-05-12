class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val charCounterMap = mutableMapOf<Char, Int>()

        for(char in s) {
            charCounterMap[char] = charCounterMap.getOrDefault(char, 0) + 1
        }

        for(char in t) {
            val check = charCounterMap[char] ?: 0
            if (check != 0) {
                charCounterMap[char] = check - 1
            }else{
                return false
            }
        }

        return true
    }
}
