import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;

    private static int[][] directions = new int[][] {
            {0,1},
            {1,0}
    };


    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs(0,0);

        if(result) {
            System.out.println("HaruHaru");
        }
        else {
            System.out.println("Hing");
        }

    }

    private static boolean bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            if(currentRow == N-1 && currentCol == N-1) {
                return true;
            }

            for(int[] direction : directions) {
                int newRow = currentRow + (direction[0] * map[currentRow][currentCol]);
                int newCol = currentCol + (direction[1] * map[currentRow][currentCol]);

                if(newRow>=0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }
}