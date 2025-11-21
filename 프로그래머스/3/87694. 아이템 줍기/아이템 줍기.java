import java.util.*;

class Solution {
    
    private static final int[][] directions = new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    private int[][] map = new int[102][102];
    private boolean[][] visited = new boolean[102][102];
    private int count = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        fillMap(rectangle);
        emptyMap(rectangle);
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return count / 2;
    }
    
    private void fillMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
    }
    
    private void emptyMap(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
    }
    
    private void bfs(int characterX, int characterY, int itemX, int itemY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int positionX = current[0];
            int positionY = current[1];
            int currentCount = current[2];
            
            if (positionX == itemX && positionY == itemY) {
                count = Math.min(count, currentCount);
                return;
            }
            
            for (int[] direction : directions) {
                int newPositionX = positionX + direction[0];
                int newPositionY = positionY + direction[1];
                if (newPositionX >= 0 && newPositionX < 102 && newPositionY >= 0 && newPositionY < 102 && !visited[newPositionX][newPositionY] &&
                   map[newPositionX][newPositionY] == 1) {
                    visited[newPositionX][newPositionY] = true;
                    deque.addLast(new int[]{newPositionX, newPositionY, currentCount + 1});
                }
            }
        }
    }
}