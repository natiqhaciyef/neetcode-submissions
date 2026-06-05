class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = mutableMapOf<String, MutableList<String>>()

        for (s in strs) {
            val sortedStr = s.toCharArray().sorted()
            val createdStr = createStringFromCharArray(sortedStr)
            val list = result.getOrDefault(createdStr, mutableListOf())
            list.add(s)
            result[createdStr] = list
        }

        return result.values.toList()
    }

    private fun createStringFromCharArray(arr: List<Char>): String{
        var str = ""
        for(ch in arr) {
            str += ch
        }
        return str
    }
}
