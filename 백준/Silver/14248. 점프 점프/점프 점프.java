import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] bridge;
    private static boolean[] visited;
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bridge = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine()) - 1;
        br.close();

        bfs(s);

        System.out.println(answer);
    }

    private static void bfs(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);
        visited[startIndex] = true;
        answer = 1;

        while (!queue.isEmpty()) {
            int currentStartIndex = queue.poll();
            int possibleMove = bridge[currentStartIndex];

            // 오른쪽 이동
            int rightPossible = currentStartIndex + possibleMove;
            if (rightPossible < n && !visited[rightPossible]) {
                queue.offer(rightPossible);
                visited[rightPossible] = true;
                answer++;
            }

            // 왼쪽 이동
            int leftPossible = currentStartIndex - possibleMove;
            if (leftPossible >= 0 && !visited[leftPossible]) {
                queue.offer(leftPossible);
                visited[leftPossible] = true;
                answer++;
            }
        }
    }
}