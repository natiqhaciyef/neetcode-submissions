class Solution {
    private val symbol = "`"

    fun encode(strs: List<String>): String {
        var result = ""
        for(str in strs) {
            result += "$str$symbol"
        }

        return result
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var current = ""

        for(ch in str) {
            if(ch == '`') {
                result.add(current)
                current = ""
                continue
            }
            current += ch
        }

        return result
    }
}
