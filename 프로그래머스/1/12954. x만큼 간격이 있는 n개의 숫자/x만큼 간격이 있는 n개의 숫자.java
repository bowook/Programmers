import java.util.*;

class Solution {
    public List<Long> solution(final int x, final int n) {
        List<Long> longs = new ArrayList<>();
        longs.add((long)x);
        for (int i = 1; i < n; i++) {
            longs.add(longs.get(i-1) + x);
        }
        
        return longs;
    }
}