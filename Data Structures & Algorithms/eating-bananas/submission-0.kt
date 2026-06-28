class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        //[1,4,3,2]
        // 1,2,2,1 
        // 1 4 3 2

        var max = 0
        for(pile in piles) {
            if(pile > max) max = pile
        }

        if(piles.size == h) return max

        var start = 1
        var end = max

        var result = max
        while(start < end) {
            val mid = (start + end) / 2

            if(isPossible(piles, mid, h)) {
                result = minOf(mid, result)
                end = mid
            }else{
                start = mid + 1
            }
        }

        return result
    }

    private fun isPossible(piles: IntArray, k: Int, h: Int): Boolean {
        var count = 0

        for(pile in piles) {
            if(pile % k == 0) count += pile/k
            else count += (pile/k + 1)
        }

        return count <= h
    }
}
