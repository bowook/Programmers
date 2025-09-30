class Solution {
    //하샤드 수가 맞는지 아닌지를 판단하는 것임
    public boolean solution(final int x) {
        String[] strs = String.valueOf(x).split("");
        
        int sum = 0;
        for (String str : strs) {
            int number = Integer.parseInt(str);
            sum += number;
        }
        
        if (x % sum == 0) {
            return true;
        }
        
        return false;
    }
}