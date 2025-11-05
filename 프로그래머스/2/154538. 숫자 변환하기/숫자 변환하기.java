import java.util.*;

class Solution {
    
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        bfs(x, y, n);
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
    
    private void bfs(int x, int y, int n) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x, 0});
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentX = current[0];
            int currentCount = current[1];
            visited[currentX] = true;
            if (currentX == y) {
                answer = Math.min(answer, currentCount);
                return;
            }
            int[] nextX = new int[]{currentX + n, currentX * 2, currentX * 3};
            for (int next : nextX) {
                if (next == y) {
                    answer = Math.min(answer, currentCount + 1);
                    return;
                }
                if (next < y && !visited[next]) {
                    deque.addLast(new int[]{next, currentCount + 1});
                }
            }
        }
    }
}