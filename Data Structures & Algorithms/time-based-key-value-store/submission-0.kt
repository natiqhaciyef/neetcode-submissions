class TimeMap() {
    private val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        val list = map.getOrDefault(key, mutableListOf())
        list.add(Pair(timestamp, value))
        map[key] = list
    }

    fun get(key: String, timestamp: Int): String {
        val list = map.getOrDefault(key, mutableListOf())
        if(list.isEmpty()) return ""

        var result = ""
        for(item in list) {
            if(item.first < timestamp) {
                result = item.second
            }else if(item.first == timestamp){
                return item.second
            }
        }

        return result
    }
}
