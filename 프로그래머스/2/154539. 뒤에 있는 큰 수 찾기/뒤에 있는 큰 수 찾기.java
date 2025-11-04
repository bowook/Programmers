import java.util.*;

class Solution {
    
    private static final int NOT_FOUND = -1;
    
    public int[] solution(int[] numbers) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i --) {
            while (!deque.isEmpty() && deque.peekLast() <= numbers[i]) {
                deque.pollLast();
            }
            
            answer[i] = deque.isEmpty() ? NOT_FOUND : deque.peekLast();
            deque.addLast(numbers[i]);
        }
        
        return answer;
    }
}