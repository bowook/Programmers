import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static String[][] grid;
    private static boolean[][] visited;

    private static int[][] directions = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    //빨간색과 초록색의 차이를 못느낌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int normalCount = 0;
        int blindCount = 0;

        grid = new String[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i ++) {
            String[] inputColors = br.readLine().split("");
            for(int j = 0; j < N; j ++) {
                grid[i][j] = inputColors[j];
            }
        }

        for (int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i,j,N, false);
                    normalCount ++;
                }
            }
        }

        visited = new boolean[N][N];

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(grid[i][j].equals("R")) {
                    grid[i][j] = "G";
                }
            }
        }


        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(!visited[i][j]) {
                    bfs(i,j,N,true);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + blindCount);
    }
    private static void bfs(int row, int col, int size, boolean blind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        String currentColor = grid[row][col];

        while(!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();
            int currentRow = currentCoordinate[0];
            int currentCol = currentCoordinate[1];

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(!blind && newRow >= 0 && newRow < size && newCol >= 0 && newCol < size &&
                grid[newRow][newCol].equals(currentColor) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow,newCol});
                }

                if(blind && newRow >= 0 && newRow < size && newCol >= 0 && newCol < size &&
                grid[newRow][newCol].equals(currentColor) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}