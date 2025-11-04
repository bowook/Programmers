import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = init(scovilles);
        while (!priorityQueue.isEmpty() && priorityQueue.peek() < K) {
            if (priorityQueue.size() < 2) {
                return -1;
            }
            
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            
            int sum = first + (second * 2);
            priorityQueue.offer(sum);
            answer += 1;
        }
        
        return answer;
    }

    private PriorityQueue<Integer> init(int[] scovilles) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int scoville : scovilles) {
            priorityQueue.offer(scoville);
        }
        
        return priorityQueue;
    }
}