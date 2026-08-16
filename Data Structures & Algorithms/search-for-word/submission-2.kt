class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) }

        for (i in board.indices) {
            for (j in board[0].indices) {

                if (backtrackToSide(board, word, 0, i, j, visited)) {
                    return true
                }

            }
        }
        return false
    }

    private fun backtrackToSide(
        board: Array<CharArray>,
        word: String,
        index: Int,
        row: Int,
        col: Int,
        visited: Array<BooleanArray>
    ): Boolean {
        if (index == word.length) return true
        if (row !in board.indices || col !in board[0].indices) return false
        if (visited[row][col] || board[row][col] != word[index]) return false


        // backtrack with dfs
        // 1. right
        // 2. left
        // 3. bottom
        // 4. top

        visited[row][col] = true

        val found = backtrackToSide(board, word, index + 1, row + 1, col, visited) ||
                backtrackToSide(board, word, index + 1, row - 1, col, visited) ||
                backtrackToSide(board, word, index + 1, row, col + 1, visited) ||
                backtrackToSide(board, word, index + 1, row, col - 1, visited)

        visited[row][col] = false
        return found
    }
}
