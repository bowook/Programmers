class Solution {
    public String solution(int num) {
        String answer = "";
        int temp_num = num % 2;
        if (temp_num != 0) {
            answer = "Odd";
        }
        else {
            answer = "Even";
        }
        return answer;
    }
}