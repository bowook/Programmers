import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }

        System.out.println(sb);
    }

    public static String bfs(int start, int arrive) {
        boolean[] visited = new boolean[10000]; // 0부터 9999까지
        String[] operations = new String[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        operations[start] = "";

        while (!queue.isEmpty()) {
            int currentCoordinate = queue.poll();

            if (currentCoordinate == arrive) {
                return operations[currentCoordinate];
            }

            // D 연산
            int next = mulDouble(currentCoordinate);
            if (!visited[next]) {
                visited[next] = true;
                operations[next] = operations[currentCoordinate] + "D";
                queue.offer(next);
            }

            // S 연산
            next = s(currentCoordinate);
            if (!visited[next]) {
                visited[next] = true;
                operations[next] = operations[currentCoordinate] + "S";
                queue.offer(next);
            }

            // L 연산
            next = left(currentCoordinate);
            if (!visited[next]) {
                visited[next] = true;
                operations[next] = operations[currentCoordinate] + "L";
                queue.offer(next);
            }

            // R 연산
            next = right(currentCoordinate);
            if (!visited[next]) {
                visited[next] = true;
                operations[next] = operations[currentCoordinate] + "R";
                queue.offer(next);
            }
        }
        return "";
    }

    public static int left(int start) {
        return start % 1000 * 10 + start / 1000;
    }

    public static int right(int start) {
        return start % 10 * 1000 + start / 10;
    }

    public static int mulDouble(int start) {
        return (start * 2) % 10000;
    }

    public static int s(int start) {
        return (start == 0) ? 9999 : start - 1; // 0일 때 9999로 변환
    }
}