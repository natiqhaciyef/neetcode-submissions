class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length == 0) return 0

        var start = 0
        var end = 0

        var maxCount = 0
        var count = 0
        var str = ""
        while(end < s.length) {
            val ch = s[end]

            if(str.contains(ch)){
                maxCount = maxOf(count, maxCount)
                start += 1                
                str = str.drop(1)
                count -= 1
            }else{
                str += ch
                count += 1
                end += 1
            }
        }

        count = end - start
        maxCount = maxOf(maxCount, count)

        return maxCount
    }
}
