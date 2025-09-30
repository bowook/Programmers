class Solution {
    // a와 b사이에 속한 모든 정수의 합 구하기
    public long solution(final int a, final int b) {
        long left = Math.min(a, b);
        long right = Math.max(a, b);
        long count = right - left + 1;
        
        return count * (left + right) / 2;
    }
}