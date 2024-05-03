class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        char temp;
        int count = 0;
        for(int i = 0; i < s.length(); i ++) {
            temp = s.charAt(i);  
            if(Character.isDigit(temp)) {
                count += 1;
            }
        }
        if(s.length() == 4 || s.length() == 6) {
            answer = true;
        }
        else {
            return false;
        }
        
        if(count == s.length()) {
            return true;
        }
        else {
            return false;
        }
    }
}