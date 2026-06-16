class MinStack() {
    private val st = ArrayDeque<Int>()
    private val list = mutableListOf<Int>()

    fun push(`val`: Int) {
        list.add(`val`)
        st.addLast(`val`)
    }

    fun pop() {
        if(list.size > 0){
            list.removeAt(list.size - 1)
            st.removeLast()
        }
    }

    fun top(): Int {
        return st.last()
    }

    fun getMin(): Int {
        if(list.size == 0) return Int.MAX_VALUE
        
        var result = list[0]
        for(item in list) {
            if(item < result)
                result = item
        }

        return result
    }
}
