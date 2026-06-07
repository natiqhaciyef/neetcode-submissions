class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if(prerequisites.size == 0) return true

        val mapCourses = mutableMapOf<Int, MutableList<Int>>()
        for(arr in prerequisites) {
            var course = arr[0]
            var dep = arr[1]

            val current = mapCourses.getOrPut(course) { mutableListOf() }
            current.add(dep)
            mapCourses[course] = current
        }


        val visited = mutableSetOf<Int>()
        fun dfs(course: Int): Boolean {
            if(course in visited) return false 

            val internalDepCourses = mapCourses[course] ?: mutableListOf() 
            if(internalDepCourses.size == 0) return true 

            visited.add(course)
            for(crs in internalDepCourses) {
                if(!dfs(crs)) return false
            }
            visited.remove(course)
            mapCourses[course] = mutableListOf()
            return true
        } 

        for(crs in 0 until numCourses) {
            if(!dfs(crs)) return false
        }
        
        return true
    }
}
