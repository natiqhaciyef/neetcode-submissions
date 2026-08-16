class Solution {
    private val list = mutableListOf<String>()
    
    fun generateParenthesis(n: Int): List<String> {
        backtrack(n, n, "")
        return list
    }

    private fun backtrack(
        remainingCorrect: Int,
        remainingReversed: Int,
        str: String
    ) {
        if(remainingCorrect == 0 && remainingReversed == 0) {
            list.add(str)
        }

        if(remainingCorrect > 0) {
            backtrack(remainingCorrect - 1, remainingReversed, str + "(")
        }

        if(remainingReversed > remainingCorrect) {
            backtrack(remainingCorrect, remainingReversed - 1, str + ")")
        }
     }


    private fun validPairs(strList: List<String>): Pair<String, Boolean> {
        var direction = 0
        val sb = StringBuilder("")

        for(s in strList) {
            if(s == "(") direction += 1
            else direction -= 1

            sb.append(s)

            if(direction < 0) return Pair("", false)
        }


        return Pair(sb.toString(), true)
    }
}
