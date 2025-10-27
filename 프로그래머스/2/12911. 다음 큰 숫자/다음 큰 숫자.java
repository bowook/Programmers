class Solution {
    public int solution(int n) {
        int oneCounts = Integer.bitCount(n);
        
        int next = 0;
        while (true) {
            n += 1;
            int nextOneCounts = Integer.bitCount(n);
            
            if (nextOneCounts == oneCounts) {
                next = n;
                break;
            }
        }
        
        return next;
    }
}