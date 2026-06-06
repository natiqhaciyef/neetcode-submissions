class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val listRow = Array(9) { mutableMapOf<Int, Boolean>() }
        val listColumn = Array(9) { mutableMapOf<Int, Boolean>() }

        // loop for row and column
        for(i in 0 until 9) {
            val mapRow = mutableMapOf<Int, Boolean>()
            val mapColumn = mutableMapOf<Int, Boolean>()
            
            for(j in 0 until 9) {
                val numRow = board[i][j]
                val numColumn = board[j][i]

                if(numRow != '.'){
                    val numRowInt = numRow.toInt()
                    val current = mapRow.getOrDefault(numRowInt, false)
                    if(current) { return false }
                    mapRow[numRowInt] = true
                }

                if(numColumn != '.') {
                    val numColumnInt = numColumn.toInt()
                    val current = mapColumn.getOrDefault(numColumnInt, false)
                    if(current) { return false }
                    mapColumn[numColumnInt] = true
                }
            }

            listRow[i] = mapRow
            listColumn[i] = mapColumn
        }

        var row = 0
        while(row < 3) {
            var column = 0

            while(column < 3) {
                val map = mutableMapOf<Int, Boolean>()
                // 0x0 -> max 0x3
                // 0x1 -> max 3x6
                // 0x2 -> max 6x9

                for(i in 0 + row*3 until 3 + row*3) {
                    for(j in 0 + column*3 until 3 + column*3) {
                        val num = board[i][j]
                        if(num == '.') continue
                        
                        val numInt = num.toInt() 
                        val current = map.getOrDefault(numInt, false)

                        if(current) { return false }
                        map[numInt] = true
                    }
                }

                column += 1
            }
            
            row += 1
        }

        return true
    }
}
