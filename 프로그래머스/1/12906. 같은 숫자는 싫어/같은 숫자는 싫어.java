import java.util.*;

public class Solution {
    public int[] solution(final int[] arr) {
        //배열의 크기는 자연수라고 했으니까 0일 수 없음.
        //배열이 비어있다는 케이스는 존재하지 않음.
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int number : arr) {
            if (stack.peek() != number) {
                stack.push(number);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i --) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}