import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i ++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        for (int count : counts) {
            if (k > 0) {
                k -= count;
                answer += 1;
                continue;
            }
            break;
        }
        
        return answer;
    }
}