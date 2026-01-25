import java.util.*;
import java.io.*;

class Main {

    private static final int[][] directions = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    
    private static int maxHeight = 0;
    private static int[][] country;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        country = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                int height = Integer.parseInt(st.nextToken());
                country[i][j] = height;

                maxHeight = Math.max(maxHeight, height);
            }
        }

        int maxSafeZones = 1; 
        
        for (int h = 1; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;
                
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && country[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            maxSafeZones = Math.max(maxSafeZones, count);
        }
        
            
        System.out.println(maxSafeZones);
    }

    private static void bfs(int row, int col, int currentHeight) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row, col});
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < country.length && newCol >= 0 && newCol < country[0].length &&
                   !visited[newRow][newCol] && country[newRow][newCol] > currentHeight) {
                    visited[newRow][newCol] = true;
                    deque.addLast(new int[]{newRow, newCol});
                   }
            }
        }
    }
}