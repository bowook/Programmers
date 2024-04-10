class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        int length = absolutes.length;
        for (int i = 0; i < length; i++) {
            if(signs[i] == true) {
                sum += absolutes[i];
            }
            else {
                sum -= absolutes[i];
            }
        }
        return sum;
    }
}