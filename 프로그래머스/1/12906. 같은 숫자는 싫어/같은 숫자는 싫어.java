import java.util.*;

public class Solution {
    public int[] solution(final int[] arr) {
        //배열의 크기는 자연수라고 했으니까 0일 수 없음.
        //배열이 비어있다는 케이스는 존재하지 않음.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(arr[0]);
        
        for(int number : arr) {
            if (deque.peekLast() != number) {
                deque.addLast(number);
            }
        }
        
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}