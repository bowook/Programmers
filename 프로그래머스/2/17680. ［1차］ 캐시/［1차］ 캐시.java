import java.util.*;

class Solution {
    
    private static final int CACHE_MISS = 5;
    private static final int CACHE_HIT = 1;
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * CACHE_MISS;
        }
        
        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);
        int latency = 0;
        
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if (cache.containsKey(lowerCity)) {
                cache.get(lowerCity);
                latency += CACHE_HIT;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.remove(cache.keySet().iterator().next());
                }
                cache.put(lowerCity, true);
                latency += CACHE_MISS;
            }
        }
        
        return latency;
    }
}