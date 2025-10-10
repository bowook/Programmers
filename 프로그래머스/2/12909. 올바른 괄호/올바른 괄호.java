import java.util.*;

class Solution {
    boolean solution(final String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        if (chars[0] == ')') {
            return false;
        }
        
        deque.addFirst(chars[0]);
        for (int i = 1; i < chars.length; i ++) {
            if (chars[i] == ')') {
                deque.pollLast();
                continue;
            }
            deque.addLast(chars[i]);
        }

        if (deque.isEmpty()) {
            return true;
        }
        return false;
    }
}