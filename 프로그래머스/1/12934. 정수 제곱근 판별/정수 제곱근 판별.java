class Solution {
    // 제곱근 판단하는 책임이 있음.
    private static final int NOT = -1;
    
    public long solution(final long n) {
        long sqrt = (long) Math.sqrt(n);
        
        if (sqrt * sqrt == n) {
            return (sqrt + 1) * (sqrt + 1);
        }
        
        return NOT;
    }
}