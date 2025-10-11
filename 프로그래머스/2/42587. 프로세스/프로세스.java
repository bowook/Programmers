import java.util.*;

class Solution {
    public int solution(final int[] priorities, final int location) {
        Deque<Process> q = setQ(priorities);
        PriorityQueue<Integer> pq = setPQ(priorities);
        
        int executeCount = 0;
        while(!q.isEmpty()) {
            Process process = q.poll();
            int priority = pq.peek();
            
            if (!process.isBiggerThan(priority)) {
                q.addLast(process);
                continue;
            }
            if (process.isBiggerThan(priority) && process.isSameLocation(location)) {
                executeCount += 1;
                break;
            }
            pq.poll();
            executeCount += 1;
        }
        
        return executeCount;
    }
    
    private Deque<Process> setQ(final int[] priorities) {
        Deque<Process> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i ++) {
            Process process = new Process(priorities[i], i);
            q.addLast(process);
        }
        
        return q;
    }
    
    private PriorityQueue<Integer> setPQ (final int[] priorities) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }
        
        return pq;
    }
}

class Process {
    private final int priority;
    private final int location;
    
    public Process(final int priority, final int location) {
        this.priority = priority;
        this.location = location;
    }
    
    public boolean isBiggerThan(final int otherPriority) {
        return this.priority >= otherPriority;
    }
    
    public boolean isSameLocation(final int location) {
        return this.location == location;
    }
}
