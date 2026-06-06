class Solution {
    private val symbol = '`'

    // Optimized: Runs in True O(n) Time
    fun encode(strs: List<String>): String {
        val result = StringBuilder()
        for (str in strs) {
            result.append(str).append(symbol)
        }
        return result.toString()
    }

    // Optimized: Runs in True O(n) Time
    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()

        for (ch in str) {
            if (ch == symbol) {
                result.add(current.toString())
                current.setLength(0)
                continue
            }
            current.append(ch)
        }

        return result
    }
}
