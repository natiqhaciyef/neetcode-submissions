class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        //pair is neighbour - weight
        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for (time in times) {
            val u = time[0]
            val v = time[1]
            val w = time[2]

            val current = map.getOrPut(u) { mutableListOf() }
            current.add(Pair(v, w))
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        minHeap.add(Pair(k, 0))

        val visited = mutableSetOf<Int>()
        var result = 0

        while (minHeap.isNotEmpty()) {
            val current = minHeap.remove() // Pair(weigh, node)

            if (current.first in visited) continue

            visited.add(current.first)
            result = max(result, current.second)

            val neighbours = map[current.first] ?: mutableListOf()
            for (neigh in neighbours) {
                if (neigh.first !in visited)
                    minHeap.add(Pair(neigh.first, neigh.second + current.second))
            }
        }


        return if (visited.size == n) result else -1
    }
}
