import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int easyWeightIdx = 0;
        int heavyWeightIdx = people.length - 1;
        
        while(easyWeightIdx <= heavyWeightIdx) {
            answer += 1;
            
            if (people[easyWeightIdx] + people[heavyWeightIdx] <= limit) {
                easyWeightIdx += 1;
            }
            
            heavyWeightIdx -= 1;
        }
        
        return answer;
    }
}