class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size <= 1) return 0
        var min = 0
        var respectedMax = prices.size-1

        var max = 1
        var respectedMin = 0

        for(i in prices.indices) {
            if(prices[min] > prices[i]) {
                min = i
            }
        }

        for(j in min until prices.size) {
            if(prices[j] > prices[respectedMax]) {
                respectedMax = j
            }
        }

        for(i in 1 until prices.size) {
            if(prices[max] < prices[i]) {
                max = i
            }
        }

        for(j in max downTo 0) {
            if(prices[j] < prices[respectedMin]) {
                respectedMin = j
            }
        }



        
        return max(prices[respectedMax] - prices[min], prices[max] - prices[respectedMin])
    }
}
