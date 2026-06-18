class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val minStack = ArrayDeque<Int>()
        val totalBars = heights.size

        for(i in 0..totalBars) {
            val currentHeight = if (i == totalBars) {
                0
            } else {
                heights[i]
            }

            while(minStack.size > 0 && heights[minStack.last()] > currentHeight) {
                val targetIndex = minStack.removeLast()
                val barHeight = heights[targetIndex]

                val left = if(minStack.size == 0) -1 else minStack.last()
                
                val width = i - left - 1
                val currentArea = barHeight * width
                maxArea = maxOf(maxArea, currentArea)
            }
            
            minStack.add(i)
        }

        return maxArea
    }
}
