class Solution {    

    fun minCostClimbingStairs(cost: IntArray): Int {
        val arr = IntArray(cost.size) { -1 }

        fun recursion(index: Int): Int {
            if(arr[index] != -1) return arr[index]
            if(index == 0 || index == 1) {
                arr[index] = cost[index]
                return cost[index]
            }

            val min1 = if(arr[index - 1] == - 1) 
                recursion(index - 1) 
            else 
                arr[index - 1]

            val min2 = if(arr[index - 2] == - 1) 
                recursion(index - 2) 
            else 
                arr[index - 2]

            arr[index] = minOf(min1, min2) + cost[index]
            return arr[index]
        }

        val result1 = recursion(cost.size - 1)
        val result2 = recursion(cost.size - 2)

        val result = minOf(result1, result2)
        return result        
    }
}
