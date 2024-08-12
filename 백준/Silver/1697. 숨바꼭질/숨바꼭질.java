import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //최단 거리를 보장해야함, dfs X -> bfs 사용
    private static int K = 0;
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //N이 수빈이의 현재 점
        K = Integer.parseInt(st.nextToken()); //K가 동생의 현재 점

        System.out.println(bfs(N));
    }

    private static int bfs(int currentCoordinate) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{currentCoordinate, 0});

        while (!queue.isEmpty()) {
            int[] pollValue = queue.poll();
            int position = pollValue[0];
            int time = pollValue[1];

            visited[position] = true;

            if (position == K) {
                //이때 시간을 리턴해줘야하는데 음.. 아 이렇게 해볼까
                //큐에다가 그냥 좌표랑 시간을 같이 넣을까 음..
                return time;
            }

            int[] possibleMoveCoordinate = new int[] {position+1,position-1,position*2};

            for(int move : possibleMoveCoordinate) {
                if(move >=0 && move <= 100000 && !visited[move]) {
                    queue.offer(new int[]{move, time+1});
                }
            }
        }
        return -1;
    }
}