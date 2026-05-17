class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val parenthesisList = listOf('(', '{', '[')
        val pair1 = Pair(')', '(')
        val pair2 = Pair('}', '{')
        val pair3 = Pair(']', '[')

        for(char in s) {
            if(char in parenthesisList){
                stack.addLast(char)
                continue
            }

            if(stack.isEmpty()) return false
            
            val last = stack.removeLast()
            when(char) {
                pair1.first -> if(last != pair1.second) return false
                pair2.first -> if(last != pair2.second) return false
                pair3.first -> if(last != pair3.second) return false
            }
        }

        return stack.isEmpty()
    }
}
