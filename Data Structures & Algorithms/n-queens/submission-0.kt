class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val results = mutableListOf<List<String>>()

        val cols = HashSet<Int>()
        val mainDiagonals = HashSet<Int>() // r - c
        val antiDiagonals = HashSet<Int>() // r + c

        val board = IntArray(n) { -1 }


        backtrack(
            results,
            board,
            cols,
            mainDiagonals,
            antiDiagonals,
            n,
            0
        )
        
        return results
    }

    fun backtrack(
        results: MutableList<List<String>>,
        board: IntArray,
        cols: HashSet<Int>,
        mainDiagonals: HashSet<Int>,
        antiDiagonals: HashSet<Int>,
        n: Int,
        row: Int
    ) {
        if (row == n) {
            results.add(buildBoard(board, n))
            return
        }

        for (col in 0 until n) {
            val mainDiag = row - col
            val antiDiag = row + col

            if (col in cols || mainDiag in mainDiagonals || antiDiag in antiDiagonals) {
                continue
            }

            cols.add(col)
            mainDiagonals.add(mainDiag)
            antiDiagonals.add(antiDiag)
            board[row] = col

            backtrack(
                results,
                board,
                cols,
                mainDiagonals,
                antiDiagonals,
                n,
                row + 1
            )

            cols.remove(col)
            mainDiagonals.remove(mainDiag)
            antiDiagonals.remove(antiDiag)
        }
    }

    private fun buildBoard(board: IntArray, n: Int): List<String> {
        return board.map { col ->
            CharArray(n) { i -> if (i == col) 'Q' else '.' }.concatToString()
        }
    }
}
