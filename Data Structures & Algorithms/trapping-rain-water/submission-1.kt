class Solution {
    fun trap(height: IntArray): Int {
        var result = 0
        if(height.size <= 2) return result

        var left = 0
        var right = height.size - 1

        var maxLeft = height[left]
        var maxRight = height[right]

        while(left < right) {

            when {
                maxLeft < maxRight -> {
                    left += 1
                    maxLeft = maxOf(maxLeft, height[left])
                    result += (maxLeft - height[left])
                }
                else -> {
                    right -= 1
                    maxRight = maxOf(maxRight, height[right])
                    result += (maxRight - height[right])
                }
            }
        }

        return result
    }
}
