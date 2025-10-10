import java.util.*;

class Solution {
    // progresses는 순서대로 먼저 배포되어야 하는 작업의 진도가 적혀있음.
    // speeds는 각 작업의 개발 속도가 적힌 정수 배열임
    // 각 배포마다 몇 개의 기능이 배포되는지를 판단하는 메서드
    private static final int DEPLOY = 100;
    
    public int[] solution(final int[] progresses, final int[] speeds) {
        Deque<Integer> remainDaysDeque = findRemainDaysFor(progresses, speeds);
        List<Integer> mappedRemainDays = new ArrayList<>();
        
        while(!remainDaysDeque.isEmpty()) {
            int remainDays = remainDaysDeque.pollFirst();
            int count = 1;
            while (!remainDaysDeque.isEmpty() && remainDays >= remainDaysDeque.peekFirst()) {
                remainDaysDeque.pollFirst();
                count += 1;
            }
            mappedRemainDays.add(count);
        }
        
        return mappedRemainDays.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private Deque<Integer> findRemainDaysFor(final int[] progresses, final int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i ++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int currentRemainDays = calculateRemainDays(progress, speed);
            deque.addLast(currentRemainDays);
        }
        
        return deque;
    }
    
    private int calculateRemainDays(final int progress, final int speed) {
        int remainDays = (DEPLOY - progress) / speed;
        int edgeCase = (DEPLOY - progress) % speed;
        if (edgeCase != 0) {
            remainDays += 1;
        }
        
        return remainDays;
    }
}