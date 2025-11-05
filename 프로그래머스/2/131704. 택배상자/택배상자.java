import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < order.length; i ++) {
            int target = order[i];
            
            while (box < target) {
                stack.push(box);
                box ++;
            }
            
            if (box == target) {
                answer ++;
                box ++;
            }
            else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer ++;
            }
            else {
                break;
            }
        }
        
        return answer;
    }
}
