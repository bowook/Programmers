class Solution {
    int answer = 0;
    int count = 0;
    boolean found = false;
    char[] alphabets = new char[]{'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    
    private void dfs(String target, String word) {
        if (word.length() > 5 || found) {
            return;
        }
        
        if (word.length() > 0) {
            count++;
        
            if (word.equals(target)) {
                answer = count;
                found = true;
                return;
            }
        }
        
        
        for (int i = 0; i < 5; i ++) {
            dfs(target, word + alphabets[i]);
        }
    }
}