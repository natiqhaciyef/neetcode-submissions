class Solution {    

    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev2 = cost[0]
        var prev1 = cost[1]

        for (i in 2 until cost.size) {
            val current = minOf(prev1, prev2) + cost[i]
            prev2 = prev1
            prev1 = current
        }

        return minOf(prev1, prev2)
    }
}
