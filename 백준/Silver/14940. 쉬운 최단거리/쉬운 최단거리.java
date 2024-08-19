import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] distances;

    private static int N = 0;
    private static int M = 0;

    private static int[][] directions = new int[][] {
            {0,1}, //동
            {0,-1}, //서
            {1,0}, //남
            {-1,0} //북
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int destinationRow  = 0;
        int destinationCol = 0;

        map = new int[N][M];
        visited = new boolean[N][M];
        distances = new int[N][M];

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    destinationRow = i;
                    destinationCol = j;
                }
            }
        }

        bfs(destinationRow, destinationCol);

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(distances[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();
            int currentRow = currentCoordinate[0];
            int currentCol = currentCoordinate[1];

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                if(newRow>=0 && newRow < N && newCol >= 0 && newCol < M &&
                map[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    distances[newRow][newCol] = distances[currentRow][currentCol] + 1;
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}