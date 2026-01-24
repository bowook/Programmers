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
    private static int paperCounts = 0;
    private static int paperSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        visited = new boolean[row][col];
        int[][] paper = new int[row][col];
        for (int i = 0; i < row; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j ++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, paper);
                    paperCounts ++;
                }
            }
        }

        System.out.println(paperCounts);
        System.out.println(paperSize);
    }

    private static void bfs(int row, int col, int[][] paper) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{row, col});
        visited[row][col] = true;

        int counts = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];

            counts ++;
            
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < paper.length && newCol >= 0 && newCol < paper[0].length &&
                   !visited[newRow][newCol] && paper[newRow][newCol] == 1) {
                    queue.addLast(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                   }
            }
        }
        paperSize = Math.max(paperSize, counts);
    }
}

