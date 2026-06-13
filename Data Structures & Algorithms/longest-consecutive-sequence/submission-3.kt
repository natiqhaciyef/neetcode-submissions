class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()
        var maxLength = 0

        for (num in numSet) {
            // Only start counting if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentLength = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    currentLength++
                }

                maxLength = maxOf(maxLength, currentLength)
            }
        }

        return maxLength
    }
}
