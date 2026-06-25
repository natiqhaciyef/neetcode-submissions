class Solution {
    fun maxArea(heights: IntArray): Int {
        var max = 0

        var left = 0
        var right = heights.size - 1

        var size = heights.size - 1

        while(left < right) {
            val start = heights[left]
            val end = heights[right]
            
            val width = right - left
            val height = minOf(start, end)

            if(max < width * height) {
                max = width * height
            }

            if(right == heights.size - 1) {
                left = 0
                size -= 1
                right = size
                
                continue
            }

            left += 1
            right += 1
        }

        return max
    }
}
