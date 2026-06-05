class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
            
        var a = 1  // f(1)
        var b = 2  // f(2)

        for (i in 3..n) {
            val temp = a + b
            a = b
            b = temp
        }

        return b
    }
}
