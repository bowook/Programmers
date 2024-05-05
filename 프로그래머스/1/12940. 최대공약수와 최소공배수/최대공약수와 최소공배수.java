class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        answer[0] = gcd(n, m); // 최대공약수
        answer[1] = (n * m) / answer[0]; // 최소공배수
        return answer;
    }
    
    // 유클리드 호제법을 사용한 최대공약수 계산
    private int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}