import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] board = new int[101];
    private static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 1; i <= 100; i++) {
            board[i] = i; // 보드판
        }

        // 사다리 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            board[startPoint] = endPoint; // 사다리 연결
        }

        // 뱀 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            board[startPoint] = endPoint; // 뱀 연결
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); //시작지점
        visited[1] = true; //시작지점 방문했으니까 true
        int count = 0;
        while (!queue.isEmpty()) {
            //이런것은 무조건 큐의 사이즈만큼 반복을 돌려줘야됨
            int size = queue.size();

            for(int i = 0; i < size; i ++) {
                int currentPosition = queue.poll();

                for(int j = 1; j <= 6; j ++) {
                    int newPosition = currentPosition + j;

                    if (newPosition > 100) {
                        continue;
                    }

                    newPosition = board[newPosition];

                    if (newPosition == 100) {
                        //지금 굴려서나온거니까 +1해줘서 리턴해야함
                        return count += 1;
                    }

                    //방문안했는데, 100도아닌상황이니까 거길 방문했다고하고 큐에 넣어줌
                    if (!visited[newPosition]) {
                        visited[newPosition] = true;
                        queue.offer(newPosition);
                    }
                }
            }
            count += 1;
        }
        return -1;
    }
}