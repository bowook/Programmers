import java.util.*;

class Solution {
    public int solution(final int n) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n; i ++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}