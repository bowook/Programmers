import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[H][W];
            String[][] grid = new String[H][W];
            for(int j = 0; j < H; j ++) {
                String[] input = br.readLine().split("");
                for(int k = 0; k < W; k ++) {
                    grid[j][k] = input[k];
                }
            }


            int result = 0;
            for(int j = 0; j < H; j ++) {
                for(int k = 0; k < W; k ++) {
                    if(grid[j][k].equals("#") && !visited[j][k]) {
                        result += 1;
                        bfs(j,k,H,W,grid,visited);
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
    private static void bfs(int row, int col,int H, int W, String[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col,1});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow>=0 && newRow < H && newCol >= 0 && newCol < W && !visited[newRow][newCol] &&
                grid[newRow][newCol].equals("#")) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}