class Solution {
    public boolean solution(int x) {
        boolean answer;
        int sum = 0;
        int y = x;
        while(x > 0) {
            int temp = x % 10;
            sum += temp;
            x = x / 10;
        }
        if(y % sum == 0) {
            answer = true;
        }
        else {
            answer = false;
        }
        return answer;
    }
}