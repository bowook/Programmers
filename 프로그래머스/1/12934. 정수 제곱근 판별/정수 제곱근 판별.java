class Solution {
    public long solution(long n) {
        long answer = 0;
        long temp = 1;
        while(true) {
            if((temp * temp) == n) {
                answer = (temp+1) * (temp+1);
                return answer;
            }
            else if ((temp * temp) > n) {
                answer = -1;
                return answer;
            }
            else {
                temp += 1;
            }
        }
        
    }
}