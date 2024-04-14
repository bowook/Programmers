class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i ++) {
            int count = 0;
            for(int j = 1; j <= i; j ++) {
                if(i % j == 0) {
                    count += 1;
                }
            }

            if(count % 2 == 0) {
                //약수의 개수가 짝수개
                sum += i;
            }
            else if (count % 2 != 0) {
                sum -= i;
            }
        }
        return sum;
    }
}