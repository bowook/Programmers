import java.util.*;

class Solution {
    
    private static final int CACHE_MISS = 5;
    private static final int CACHE_HIT = 1;
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * CACHE_MISS;
        }
        
        Deque<String> deque = new ArrayDeque<>();
        int latency = 0;

        for (int i = 0; i < cities.length; i ++) {
            String city = cities[i].toLowerCase();
            if (deque.contains(city)) {
                latency += CACHE_HIT;
                deque.remove(city);
                deque.addLast(city);
                continue;
            }
            latency += CACHE_MISS;
            if (deque.size() >= cacheSize) {
                deque.pollFirst();
            }
            deque.addLast(city);
        }

        return latency;
    }
}
