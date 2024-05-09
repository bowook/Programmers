class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i ++) {
            char temp = s.charAt(i);
            int idx_signal = -1;
            boolean signal = false;
            for (int j =0; j < i; j++) {
                if (temp == s.charAt(j)) {
                    signal = true;
                    idx_signal = j;
                }
            }
            if(signal) {
                //앞에 겹치는게 있던거임
                answer[i] = Math.abs(idx_signal - i);
            }
            else if (!signal) {
                //앞에 겹치는게 없음
                answer[i] = -1;
            }
        }
        return answer;
    }
}