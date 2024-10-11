import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] maze;
    private static boolean[] visited;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maze = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i ++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int result = bfs(0);
        System.out.println(result);
    }

    private static int bfs(int startIndex) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startIndex,0});
        visited[startIndex] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0] + 1;
            int currentStep = current[1];
            int possibleMove = maze[currentPosition-1] + currentPosition;


            if(currentPosition == N) {
                return currentStep;
            }

            for(int i = currentPosition; i < possibleMove; i ++) {
                if(i < N && !visited[i]) {
                    queue.offer(new int[]{i, currentStep + 1});
                    visited[i] = true;
                }
            }

        }

        return -1;
    }


}