class Solution {
    public long solution(int price, int money, int count) {
        //놀이기구 원래 이용로 price
        //money는 가지고 있는 돈
        long answer = 0;
        for(int i = 1; i <= count; i ++) {
            answer += i * price;
        }
        answer = answer - money;
        
        if(answer < 0) {
            answer = 0;
        }

        return answer;
    }
}