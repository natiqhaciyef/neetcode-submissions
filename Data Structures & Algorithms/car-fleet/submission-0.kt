class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = Array(position.size) { i -> Pair(position[i], speed[i]) }
        cars.sortByDescending { it.first }

        var fleets = 0
        var slowestTimeAhead = 0.0

        for (car in cars) {
            val pos = car.first
            val sp = car.second

            val timeToTarget = (target - pos).toDouble() / sp

            if (timeToTarget > slowestTimeAhead) {
                slowestTimeAhead = timeToTarget
                fleets += 1
            }
        }

        return fleets
    }
}
