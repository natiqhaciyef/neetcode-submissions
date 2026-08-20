class Solution {
    private val list = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if(digits.length == 0) return listOf()
        val grid = arrayOf(
            CharArray(0),
            charArrayOf('a', 'b', 'c'),
            charArrayOf('d', 'e', 'f'),
            charArrayOf('g', 'h', 'i'),
            charArrayOf('j', 'k', 'l'),
            charArrayOf('m', 'n', 'o'),
            charArrayOf('p', 'q', 'r', 's'),
            charArrayOf('t', 'u', 'v'),
            charArrayOf('w', 'x' , 'y', 'z')
        )

        backtrack(grid, digits, 0, "")
        return list
    }

    private fun backtrack(
        grid: Array<CharArray>,
        digits: String,
        index: Int,
        str: String
    ) {
        if(digits.length == index || digits.length == str.length) {
            list.add(str)
            return
        }

        val current = digits[index].digitToInt()

        for(ch in grid[current - 1]) {
            backtrack(grid, digits, index + 1, str + ch)
        }

    }
}
