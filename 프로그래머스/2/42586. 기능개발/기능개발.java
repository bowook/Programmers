import java.util.*;

class Solution {
    // progresses는 순서대로 먼저 배포되어야 하는 작업의 진도가 적혀있음.
    // speeds는 각 작업의 개발 속도가 적힌 정수 배열임
    // 각 배포마다 몇 개의 기능이 배포되는지를 판단하는 메서드
    private static final int DEPLOY = 100;
    
    public int[] solution(final int[] progresses, final int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> remainDaysList = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i ++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int currentRemainDays = calculateRemainDays(progress, speed);
            if (deque.isEmpty()) {
                deque.addLast(currentRemainDays);
                remainDaysList.add(1);
                continue;
            }
            int beforeProgressRemainDays = deque.peekLast();
            if (beforeProgressRemainDays >= currentRemainDays) {
                int lastIndex = remainDaysList.size() - 1;
                int lastValue = remainDaysList.get(lastIndex);
                remainDaysList.set(lastIndex, lastValue + 1);
                continue;
            }
            deque.addLast(currentRemainDays);
            remainDaysList.add(1);
        }
        
        return remainDaysList.stream().mapToInt(Integer::intValue).toArray();
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