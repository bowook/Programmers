import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] storage;

    private static boolean[][] visited;

    private static int[][] directions = new int[][] {
            {0,1}, //동
            {0,-1},//서
            {1,0}, //남
            {-1,0} //북
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        storage = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
                if(storage[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int result = bfs(queue, N, M);
        System.out.println(result);
    }

    private static int bfs(Queue<int[]> queue, int row, int col) {
        int days = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            days += 1;

            for(int i = 0; i < size; i ++) {
                int[] currentCoordinate = queue.poll();
                int currentRow = currentCoordinate[0]; //토마토가 하나 이상은 반드시 주어지니까 상관없음
                int currentCol = currentCoordinate[1];

                for(int[] direction : directions) {
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if(newRow>=0 && newRow<row && newCol >=0 & newCol < col &&
                    storage[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[] {newRow, newCol});
                        //1로바꿔야됨
                        storage[newRow][newCol] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j++) {
                if(storage[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;
    }
}