import java.util.*;

class Solution {
    
    private final int[][] directions= new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    
    private boolean[][] visited;
    private int answer = Integer.MAX_VALUE;
    private int maxRow;
    private int maxCol;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        maxRow = maps.length;
        maxCol = maps[0].length;
        
        bfs(maps, new int[]{0,0,1});
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
    
    private void bfs(int[][] maps, int[] position) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(position);
        visited[position[0]][position[1]] = true;
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int row = current[0];
            int col = current[1];
            int count = current[2];
            
            if (row == maxRow - 1 && col == maxCol - 1) {
                answer = Math.min(answer, count);
                return;
            } 
            
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                if (newRow >= 0 && newRow < maxRow && newCol >= 0 && newCol < maxCol && maps[newRow][newCol] == 1
                   && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    deque.addLast(new int[]{newRow, newCol, count + 1});
                }
            }
        }
    }
}
