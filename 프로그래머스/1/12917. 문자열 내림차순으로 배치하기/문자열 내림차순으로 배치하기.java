//대문자는 소문자보다 작다
//큰것부터 작은값으로 정렬, 내림차순
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int [] num_ascii = new int[s.length()];
        for(int i = 0; i < s.length(); i ++) {
            num_ascii[i] = (int)s.charAt(i);
        }
        
        for(int i=0; i<num_ascii.length-1; i++) {
            for(int j=0; j<num_ascii.length-1-i; j++)	{
                if(num_ascii[j] < num_ascii[j+1]) {
                    int tmp = num_ascii[j];			
					num_ascii[j] = num_ascii[j+1];			
					num_ascii[j+1] = tmp;
                }
            }
        }
        
        for(int i = 0; i <num_ascii.length; i ++) {
            answer += (char)num_ascii[i];
        }
        return answer;
    }
}