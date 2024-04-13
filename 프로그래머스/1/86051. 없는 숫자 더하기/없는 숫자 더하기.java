class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int length = numbers.length;
        for(int i = 0; i < length; i ++) {
            answer += numbers[i];
        }
        answer = 45 - answer;
        return answer;
    }
}