import java.util.*;
import java.io.*;

class Main {

    private static final int[][] directions = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i ++) {
            String[] values = br.readLine().split("");
            for (int j = 0; j < M; j ++) {
                maze[i][j] = Integer.parseInt(values[j]);
            }
        }

        int counts = bfs(0,0, N, M, maze);

        System.out.println(counts);
    }

    private static int bfs(int row, int col, int N, int M, int[][] maze) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row, col, 1});
        visited[row][col] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentCount = current[2];

            if (currentRow == N -1 && currentCol == M - 1) {
                return currentCount;
            }
            
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length &&
                   !visited[newRow][newCol] && maze[newRow][newCol] == 1) {
                    deque.addLast(new int[]{newRow, newCol, currentCount + 1});
                    visited[newRow][newCol] = true;
                   }
             }
        }

        return 0;
    }
}

