//입력된 숫자가 짝수면 2로 나누기
//입력된 수가 홀수면 3을 곱하고 1을 더하기
//결과로 나온 수에 같은 작업을 1이 될 때까지 반복
class Solution {
    public int solution(int num) {
        int answer = num;
        int count = 0;
        while(answer != 1) {
            if(answer % 2 == 0) {
                //짝수
                answer = answer / 2;
            }
            else if(answer % 2 == 1) {
                //홀수
                answer = (answer * 3) + 1;
            }
            
            if(count >= 500) {
                count = -1;
                break;
            }
            count += 1;      
        }
        return count;
    }
}