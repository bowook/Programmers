class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if(length % 2 == 0) {
            //짝수
            length = length / 2;
            answer += s.charAt(length - 1);
            answer += s.charAt(length);
        }
        else if (length % 2 == 1) {
            //홀수
            length = length / 2;
            answer += s.charAt(length);
            
        }
        return answer;
    }
}