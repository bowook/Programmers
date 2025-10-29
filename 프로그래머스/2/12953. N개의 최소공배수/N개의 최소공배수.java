class Solution {
    public int solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            int gcdValue = gcd(arr[i], arr[i+1]);
            int lcmValue = lcm(arr[i], arr[i+1], gcdValue);
            arr[i+1] = lcmValue;
        }
        
        return arr[arr.length-1];
    }
    
    private int lcm(int num1, int num2, int gcdValue) {
        return (num1 * num2) / gcdValue;
    }
    
    private int gcd(int num1, int num2) {
        int remain = Integer.MAX_VALUE;
        while(remain != 0) {
            int temp = 0;
            if (num2 > num1) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            
            int num = num1 / num2;
            remain = num1 % num2;
            
            if (remain != 0) {
                num1 = num2;
                num2 = remain;
            }
        }
        
        return num2;
    }
    
}