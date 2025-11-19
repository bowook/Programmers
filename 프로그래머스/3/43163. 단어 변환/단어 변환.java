import java.util.*;

class Solution {
    
    private int counts = Integer.MAX_VALUE;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        if (!findEqualsWord(target, words)) {
            return 0;
        }
        visited = new boolean[words.length];
        bfs(begin, target, words);
        
        return counts;
    }
    
    private void bfs(String begin, String target, String[] words) {
        Deque<String[]> deque = new ArrayDeque<>();
        deque.addLast(new String[]{begin, "0"});
        
        while(!deque.isEmpty()) {
            String[] current = deque.pollFirst();
            String currentWord = current[0];
            int currentCounts = Integer.parseInt(current[1]);
            
            if (currentWord.equals(target) && currentCounts <= counts) {
                counts = currentCounts;
                return;
            }
            
            for (int i = 0; i < words.length; i ++) {
                String word = words[i];
                if (!visited[i] && judgeDifferenceAlphabet(currentWord, word)) {
                    deque.addLast(new String[]{word, String.valueOf(currentCounts + 1)});
                    visited[i] = true;
                }
            }
        }
    }
    
    private boolean judgeDifferenceAlphabet(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i ++) {
            char ch = begin.charAt(i);
            if (ch != word.charAt(i)) {
                count += 1;
            }
        }
        
        if (count > 1) {
            return false;
        }
        return true;
    }
    
    private boolean findEqualsWord(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        
        return false;
    }
}