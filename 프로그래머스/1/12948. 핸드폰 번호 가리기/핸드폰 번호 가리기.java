class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        
        if(length == 4) {
            //무조건 4 길이
            for(int i = 0; i < length; i ++) {
                answer += phone_number.charAt(i);
            }
        }
        else {
            //무조건 5 ~ 20 길이
            int temp_length = length - 4;
            for(int i = 0; i < temp_length; i++) {
                answer += "*";
            }
            for(int i = temp_length; i < length; i ++) {
                answer += phone_number.charAt(i);
            }
        }
        return answer;
    }
}