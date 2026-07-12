class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)

        var start = 0
        var end = k - 1

        while(end < nums.size) {
            val max = findMax(start, end, nums)
            println("max: $max")
            result[start] = max
            start += 1
            end += 1
        }

        return result
    }

    private fun findMax(start: Int, end : Int, arr: IntArray): Int {
        var max = arr[start]

        for(i in start + 1 .. end) {
            if(max < arr[i])
                max = arr[i]
        }

        return max
    }
}
