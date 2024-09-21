import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] city;
    private static boolean[][] visited;
    private static int N,M;

    private static int[][] directions = new int[][] {
            {0,1},
            {1,0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String result = bfs(0,0);
        System.out.println(result);
    }

    private static String bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            if(currentRow == M-1 && currentCol == N-1) {
                return "Yes";
            }

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow >= 0 && newRow < M && newCol >= 0 && newCol < N && !visited[newRow][newCol] &&
                city[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }


        }

        return "No";
    }
}