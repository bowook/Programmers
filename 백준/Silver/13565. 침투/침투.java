import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //0은 전류가 통하는 것
    //1은 전류가 통하지 않는 것
    private static int M,N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i ++) {
            String[] flags = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(flags[j]);
            }
        }

        br.close();

        for(int i = 0; i < N; i ++) {
            if(map[0][i] == 0 && !visited[0][i]) {
                if(bfs(i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    private static boolean bfs(int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,col});
        visited[0][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            if(currentRow == M-1) {
                return true;
            }

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow >=0 && newRow < M && newCol >= 0 && newCol < N && !visited[newRow][newCol] &&
                map[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }


        }

        return false;
    }
}