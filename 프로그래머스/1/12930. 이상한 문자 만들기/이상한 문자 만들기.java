import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0; // 전체 문자열에서의 인덱스
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == ' ') {
                answer.append(' ');
                index = 0; // 단어별로 인덱스를 리셋
            } else {
                if(index % 2 == 0) {
                    answer.append(Character.toUpperCase(currentChar)); // 짝수 인덱스
                } else {
                    answer.append(Character.toLowerCase(currentChar)); // 홀수 인덱스
                }
                index++;
            }
        }
        
        return answer.toString();
    }
}
