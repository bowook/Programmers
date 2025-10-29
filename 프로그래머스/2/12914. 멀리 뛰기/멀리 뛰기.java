class Solution {
    public long solution(int n) {
        int[] distance = new int[n+1];
        distance[1] = 1;
        if (n == 1) {
            return distance[1];
        }
        
        distance[2] = 2;

        for (int i = 3; i <= n; i ++) {
            distance[i] = (distance[i-1] + distance[i-2]) % 1234567;
        }
        
        return distance[n];
    }
}