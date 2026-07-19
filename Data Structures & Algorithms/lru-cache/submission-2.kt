class LRUCache(val capacity: Int) {
    // Key -> Pair(Value, LastAccessedTimestamp)
    private val map = mutableMapOf<Int, Pair<Int, Int>>()
    
    private var logicalTime = 0
    private var minTimePointer = 0

    fun get(key: Int): Int {
        val entry = map[key] ?: return -1
        
        // Update the timestamp to mark it as Most Recently Used
        logicalTime += 1
        map[key] = Pair(entry.first, logicalTime)
        
        return entry.first
    }

    fun put(key: Int, value: Int) {
        logicalTime += 1

        if (map.containsKey(key)) {
            // Key exists: update its value and its recency timestamp
            map[key] = Pair(value, logicalTime)
            return
        }

        // Key doesn't exist: check capacity boundaries before adding
        if (map.size >= capacity) {
            evictLeastRecentlyUsed()
        }

        map[key] = Pair(value, logicalTime)
    }

    private fun evictLeastRecentlyUsed() {
        // Amortized check: advance our pointer until we find the key 
        // that actually owns the oldest active timestamp.
        while (true) {
            // Find which key claims to be the owner of this historical time tick
            val potentialKey = map.entries.find { it.value.second == minTimePointer }?.key
            
            if (potentialKey != null) {
                // Verified: This key hasn't been updated since minTimePointer. Evict it!
                map.remove(potentialKey)
                minTimePointer += 1
                break
            }
            
            // If no active key owns this time tick, it means that key was updated 
            // later or overwritten. Skip this tick and move forward.
            minTimePointer += 1
        }
    }
}
