import java.util.*;
import java.io.*;

public class Main {
    
    private static String SPACE = " ";
    private static int[][] directions = new int[][] {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    private static boolean[][] visited;
    private static int[][] paper;
    private static int maxRow;
    private static int maxCol;
    private static int maxPaintingExtent = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startline = br.readLine().split(SPACE);
        maxRow = Integer.parseInt(startline[0]);
        maxCol = Integer.parseInt(startline[1]);
        
        visited = new boolean[maxRow][maxCol];
        paper = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i ++) {
            String[] paintings = br.readLine().split(SPACE);
            for (int j = 0; j < maxCol; j ++) {
                paper[i][j] = Integer.parseInt(paintings[j]);
            }
        }
        
        int paintingCounts = 0;
        for (int i = 0; i < maxRow; i ++) {
            for (int j = 0; j < maxCol; j ++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                    paintingCounts += 1;
                }
            }
        }
        
        System.out.println(paintingCounts);
        System.out.println(maxPaintingExtent);
    }
    
    private static void bfs(int row, int col) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row,col});
        visited[row][col] = true;
        
        int currentExtent = 0;
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            currentExtent += 1;
            
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                
                if (newRow >= 0 && newRow < maxRow &&
                   newCol >= 0 && newCol < maxCol && !visited[newRow][newCol]
                   && paper[newRow][newCol] == 1) {
                    deque.addLast(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        maxPaintingExtent = Math.max(maxPaintingExtent, currentExtent);
    }
}
