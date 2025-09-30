class Solution {
    // a와 b사이에 속한 모든 정수의 합 구하기
    public long solution(final int a, final int b) {
        long sum = 0;
        if (a == b) {
            return a;
        }
        else if (a > b) {
            for (int i = b; i <= a; i ++) {
                sum += i;
            }
        }
        else {
            for (int i = a; i <= b; i ++) {
                sum += i;
            }
        }
        
        return sum;
    }
}