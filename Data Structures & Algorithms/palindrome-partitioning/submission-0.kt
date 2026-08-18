class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val currentPath = mutableListOf<String>()
        
        val n = s.length
        val isPalindrome = Array(n) { BooleanArray(n) }
        for (right in 0 until n) {
            for (left in 0..right) {
                if (s[left] == s[right] && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true
                }
            }
        }

        fun backtrack(start: Int) {
            if (start == s.length) {
                result.add(ArrayList(currentPath))
                return
            }

            for (end in start until s.length) {
                if (isPalindrome[start][end]) {
                    currentPath.add(s.substring(start, end + 1))
                    backtrack(end + 1)
                    currentPath.removeAt(currentPath.size - 1)
                }
            }
        }

        backtrack(0)
        return result
    }
}
