class Solution {
    public int solution(final int n) {
        int answer = 0;
        int half = n / 2;
        for (int i = 1; i <= half; i ++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        
        return answer + n;
    }
}