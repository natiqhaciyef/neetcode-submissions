class Solution {
    var prev1 = 1
    var prev2 = 1
    fun climbStairs(n: Int): Int {
        if(n < 2) return n

        return dfs(n - 1)
    }

    private fun dfs(remaining: Int): Int {
        if(remaining == 1) {
            return prev1 + prev2
        }

        if(remaining < 1) return 0

        var count = prev1
        prev1 = prev2
        prev2 = prev1 + count
        
        return dfs(remaining - 1)
    } 
}
