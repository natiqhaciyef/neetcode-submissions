class PrefixTree {
    private val head = CustomTree('-')
    private val map = mutableMapOf<String, Boolean>()

    fun insert(word: String) {
        var current = head
        map[word] = true
        
        for(ch in word) {
            if(current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = CustomTree(ch)
            }

            current = current.children[ch - 'a']!!
        }
    }

    fun search(word: String): Boolean {
        return map[word] != null
    }

    fun startsWith(prefix: String): Boolean {
        var current = head
        for(ch in prefix) {
            if(current.children[ch - 'a'] == null) {
                return false
            }

            current = current.children[ch - 'a']!!
        }

        return true
    }
}

class CustomTree(val value: Char) {
    val children = Array<CustomTree?>(26) { null }
}
