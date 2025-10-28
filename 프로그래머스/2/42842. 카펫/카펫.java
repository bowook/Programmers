import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpetSize = brown + yellow;
        
        Deque<Integer> deque = findWidthAndHeight(carpetSize);
        while (true) {
            int width = deque.pollFirst();
            int height = deque.pollFirst();
            
            if((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        int temp = 0;
        if (answer[1] > answer[0]) {
            temp = answer[0];
            answer[0] = answer[1];
            answer[1] = temp;
        }
        
        return answer;
    }
    
    private Deque<Integer> findWidthAndHeight(int size) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int sqrtSize = (int)Math.sqrt(size);
        int height = 3;
        while(true) {
            if (height > sqrtSize) {
                break;
            }

            if (size % height == 0) {
                int width = size / height;
                deque.addLast(width);
                deque.addLast(height);
            }
            height ++;
        }
        
        return deque;
    }
}