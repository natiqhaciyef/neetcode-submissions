class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val last = matrix[0].size - 1
        var row = 0

        while(row < matrix.size) {            
            if(target <= matrix[row][last]) break
            row += 1
        }

        if (row >= matrix.size)
            return false

        // row found
        val arr = matrix[row]

        var start = 0 
        var end = arr.size

        while(start < end) {
            val mid = (end + start) / 2
            if (arr[mid] == target)
                return true

            if (arr[mid] > target) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return false
    }
}
