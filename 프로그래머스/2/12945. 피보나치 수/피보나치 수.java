class Solution {
    private static final int divideNumber = 1234567;
    
    public int solution(int n) {
        int[] savedFibos = new int[n+1];
        savedFibos[0] = 0;
        savedFibos[1] = 1;
        
        for (int i = 2; i <= n; i ++) {
            int fibo = savedFibos[i-1] + savedFibos[i-2];
            savedFibos[i] = fibo % divideNumber;
        }
        
        return savedFibos[n];
    }
}