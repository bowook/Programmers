import java.util.*;
import java.io.*;

public class Main {
    
    private static final int[][] directions = new int[][]{
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    private static final String WALL = "#";
    private static final String FIRE = "F";
    private static final String MOVABLE = ".";
    private static final String INIT_POSITION = "J";
    
    private static String[][] maze;
    private static boolean[][] visited;
    private static int row;
    private static int col;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startLine = br.readLine().split(" ");
        row = Integer.parseInt(startLine[0]);
        col = Integer.parseInt(startLine[1]);
        
        visited = new boolean[row][col];
        maze = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] values = br.readLine().split("");
            for (int j = 0; j < col; j ++) {
                maze[i][j] = values[j];
            }
        }

        Deque<int[]> jihunQueue = new ArrayDeque<>();
        Deque<int[]> fireQueue = new ArrayDeque<>();
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (maze[i][j].equals(INIT_POSITION)) {
                    jihunQueue.addLast(new int[]{i,j,1});
                    visited[i][j] = true;
                    continue;
                }
                
                if (maze[i][j].equals(FIRE)) {
                    fireQueue.addLast(new int[]{i,j});
                }
            }
        }
        
        bfs(jihunQueue, fireQueue);
    }
    
    private static void bfs(Deque<int[]> jihunQueue, Deque<int[]> fireQueue) {
        while (!jihunQueue.isEmpty()) {
            //불먼저 확장해야함
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i ++) {
                int[] fire = fireQueue.pollFirst();
                int currentFireRow = fire[0];
                int currentFireCol = fire[1];
                
                for (int[] direction : directions) {
                    int newFireRow = currentFireRow + direction[0];
                    int newFireCol = currentFireCol + direction[1];
                    
                    if (newFireRow >= 0 && newFireRow < row &&
                       newFireCol >= 0 && newFireCol < col &&
                       (maze[newFireRow][newFireCol].equals(MOVABLE) ||
                       maze[newFireRow][newFireCol].equals(INIT_POSITION))) {
                        maze[newFireRow][newFireCol] = FIRE;
                        fireQueue.addLast(new int[]{newFireRow, newFireCol});
                    }
                }
            }
            
            //지훈이 이동해야함
            int jihunSize = jihunQueue.size();
            for (int i =  0; i < jihunSize; i ++) {
                int[] jihun = jihunQueue.pollFirst();
                int currentJihunRow = jihun[0];
                int currentJihunCol = jihun[1];
                int currentJihunMoves = jihun[2];
            
                if (currentJihunRow == 0 || currentJihunRow == row -1 ||
                   currentJihunCol == 0 || currentJihunCol == col -1) {
                    System.out.println(currentJihunMoves);
                    return;
                }
            
                for (int[] direction : directions) {
                    int newJihunRow = currentJihunRow + direction[0];
                    int newJihunCol = currentJihunCol + direction[1];
                
                    if (newJihunRow >= 0 && newJihunRow < row &&
                      newJihunCol >= 0 && newJihunCol < col &&
                      !visited[newJihunRow][newJihunCol] &&
                      maze[newJihunRow][newJihunCol].equals(MOVABLE)) {
                        jihunQueue.addLast(new int[]{newJihunRow, newJihunCol, currentJihunMoves + 1});
                        visited[newJihunRow][newJihunCol] = true;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
