class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false


        val arr1 = IntArray(26)
        for(ch in s1) {
            arr1[ch - 'a'] += 1
        }

        var start = 0
        var end = s1.length - 1
        val arr2 = IntArray(26)

        for(i in 0..end) {    
            val ch = s2[i]
            arr2[ch - 'a'] += 1
        }

        fun matches(): Boolean = arr1.contentEquals(arr2)

        while(end < s2.length) {            
            if(matches()) return true

            val startCh = s2[start]
            arr2[startCh - 'a'] -= 1

            if(end + 1 < s2.length) {                
                val endCh = s2[end + 1]
                arr2[endCh - 'a'] += 1 
            }

            start += 1
            end += 1
        }


        return false
    }
}
