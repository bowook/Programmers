class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int trans = 0;
        int deletedZero = 0;
        
        while(!s.equals("1")) {
            String transS = "";
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    deletedZero += 1;
                    continue;
                }
                transS += ch;
            }
            
            int len = transS.length();
            s = Integer.toBinaryString(len);
            
            trans += 1;
        }
        answer[0] = trans;
        answer[1] = deletedZero;
        
        return answer;
    }
}