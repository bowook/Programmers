import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String temp = String.valueOf(n);
        String[] arr = temp.split("");
        String temp2 = "";
        Arrays.sort(arr);
        for (int i = arr.length-1; i >=0; i--) {
            temp2 += arr[i];
        }
        answer = Long.valueOf(temp2);
        
        return answer;
    }
}