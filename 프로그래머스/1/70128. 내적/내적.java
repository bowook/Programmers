class Solution {
    public int solution(int[] a, int[] b) {
        int sum = 0;
        int numLength = a.length;
        for(int i = 0; i < numLength; i ++) {
            sum = sum + (a[i] * b[i]);
        }
        return sum;
    }
}