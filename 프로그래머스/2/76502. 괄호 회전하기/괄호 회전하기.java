import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }
        
        //회전을 총 문자열의 길이만큼 할 수 있음.
        for(int i = 0; i < s.length(); i ++) {
            if (isRight(deque)) {
                answer += 1;
            }
            char rotated = deque.pollFirst();
            deque.addLast(rotated);
        }
        
        return answer;
    }
    
    private boolean isRight(Deque<Character> deque) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : deque) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }
            
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == ']' && top != '[') return false;
            if (c == '}' && top != '{') return false;
        }
        
        return stack.isEmpty();
    }
}