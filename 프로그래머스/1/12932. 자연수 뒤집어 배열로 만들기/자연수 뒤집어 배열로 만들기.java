class Solution {
    public int[] solution(long n) {
        
        String str = "" + n;
        int[] answer = new int[str.length()];
        
        int count = 0;
        
        while(n > 0) {
            answer[count] = (int)(n%10);
            n = n / 10;
            count++;
        }
        
        return answer;
    }
}