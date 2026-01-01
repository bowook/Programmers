import java.util.*;
import java.io.*;

public class Main {
    
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int maxNumber;
    private static int maxLength;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxNumber = Integer.parseInt(st.nextToken());
        maxLength = Integer.parseInt(st.nextToken());
        visited = new boolean[maxNumber + 1];

        solve(new ArrayDeque<>());

        System.out.println(sb.toString());
    }

    private static void solve(Deque<Integer> numbers) {
        if (numbers.size() == maxLength) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= maxNumber; i ++) {
            if (!visited[i]) {
                numbers.addLast(i);
                visited[i] = true;

                solve(numbers);

                numbers.removeLast();
                visited[i] = false;
            }
        }
    }
}