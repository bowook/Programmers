class Solution {
    public String solution(int n) {
        String answer = "수";
        //n은 자연수니까 일단 무조건 "수"는 들어가있음
        for(int i = 1; i < n; i ++) {
            if(i % 2 == 1) {
                answer += "박";
            }
            else if (i % 2 == 0) {
                answer += "수";
            }
        }
        return answer;
    }
}