class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1

        while(l < r) {
            val sum = numbers[l] + numbers[r]
            if(sum > target) {
                r -= 1
            }else if(sum < target) {
                l += 1
            }else{
                return intArrayOf(l + 1, r + 1)
            }
        }


        return intArrayOf()
    }
}
