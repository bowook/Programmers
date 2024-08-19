import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] storage;
    private static boolean[][][] visited;
    private static int[][] directions = new int[][] {
            {0, 1, 0}, // 동
            {0, -1, 0}, // 서
            {1, 0, 0}, // 남
            {-1, 0, 0}, // 북
            {0, 0, 1}, // 위
            {0, 0, -1} // 아래
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); //열의 개수
        int N = Integer.parseInt(st.nextToken()); //행의 개수
        int H = Integer.parseInt(st.nextToken()); //상자의 수

        storage = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    storage[h][n][m] = Integer.parseInt(st.nextToken());
                    if (storage[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                        visited[h][n][m] = true;
                    }
                }
            }
        }
        int result = bfs(queue, H, N, M);

        System.out.println(result);
    }

    private static int bfs(Queue<int[]> queue, int H, int N, int M) {
        //처음 파라미터로 전달받는 큐는 1이 들어있는 곳에 H,N,M임 그러면, 여기서 첫째날에 이 근처는 다 0이면
        //토마토로 바뀌어야함 그래서 큐의 사이즈를 해서 큐가 비어지면 days를 증가해야함
        
        //H가 상자의 개수, N이 행의 개수, M이 열의 개수
        int days = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            days += 1;

            for(int i = 0; i < size; i ++) {
                int[] currentCoordinate = queue.poll();
                int currentBox = currentCoordinate[0];
                int currentRow = currentCoordinate[1];
                int currentCol = currentCoordinate[2];

                for(int[] direction : directions) {
                    int newBox = currentBox + direction[0];
                    int newRow = currentRow + direction[1];
                    int newCol = currentCol + direction[2];

                    if(newBox >= 0 && newBox < H && newRow >=0 && newRow<N && newCol>=0 && newCol < M &&
                            storage[newBox][newRow][newCol] == 0 && !visited[newBox][newRow][newCol]) {
                        visited[newBox][newRow][newCol] = true;
                        queue.offer(new int[]{newBox, newRow, newCol});
                        //1로 바꿔야됨
                        storage[newBox][newRow][newCol] = 1;
                    }
                }
            }
        }

        for(int h = 0; h < H; h ++) {
            for(int n = 0; n < N; n ++) {
                for(int m = 0; m < M; m ++) {
                    if (storage[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;

    }
}