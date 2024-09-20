import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited = new boolean[1000001];

    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(A,0);
        System.out.println(result);
    }

    private static int bfs(int A, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{A,count});
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNumber = current[0];
            int currentCount = current[1];

            if(currentNumber == K) {
                return currentCount;
            }

            int newNumber = currentNumber + 1;
            if(newNumber>=1 && newNumber<=1000000 && !visited[newNumber]) {
                queue.offer(new int[]{newNumber, currentCount+1});
                visited[newNumber] = true;
            }

            newNumber = currentNumber * 2;
            if(newNumber>=1 && newNumber<=1000000 && !visited[newNumber]) {
                queue.offer(new int[]{newNumber, currentCount+1});
                visited[newNumber] = true;
            }

        }

        return -1;
    }
}