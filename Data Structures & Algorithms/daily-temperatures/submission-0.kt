class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        var point1 = 0
        var point2 = 0

        val result = IntArray(temperatures.size)
        while(point1 < temperatures.size) {
            point2 = point1
            while(point2 < temperatures.size) {
                if(temperatures[point1] < temperatures[point2]){
                    break
                }

                point2 += 1
            }

            if(point2 >= temperatures.size) point2 = 0

            result[point1] = if(point2 != 0) (point2 - point1) else 0
            point1 += 1
        }

        return result
    }
}
