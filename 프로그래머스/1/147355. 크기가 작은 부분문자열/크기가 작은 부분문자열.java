class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String tempStr = t.substring(i, i + p.length());
            if (tempStr.compareTo(p) <= 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
