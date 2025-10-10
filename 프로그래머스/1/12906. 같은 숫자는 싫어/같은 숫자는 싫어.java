import java.util.*;

public class Solution {
    public int[] solution(final int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int number : arr) {
            if (stack.peek() != number) {
                stack.push(number);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i ++) {
            answer[i] = stack.get(i);
        }
        
        return answer;
    }
}