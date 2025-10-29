import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        
        for(int i = 1; i < words.length; i ++) {
            char beforeLast = words[i-1].charAt(words[i-1].length() - 1);
            char currentFront = words[i].charAt(0);
            
            if(beforeLast != currentFront) {
                return calculate(n, i);
            }
            boolean isSuccess = wordSet.add(words[i]);
            
            if(!isSuccess) {
                return calculate(n, i);
            }
        }
        
        return new int[]{0,0};
    }
    
    private int[] calculate(int n, int idx) {
        int number = (idx % n) + 1;
        int order = (idx / n) + 1;
        
        return new int[]{number, order};
    }
}