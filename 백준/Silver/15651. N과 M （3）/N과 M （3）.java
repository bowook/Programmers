import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int M;
    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve(new ArrayDeque<>());
        
        System.out.println(sb);
    }

    private static void solve(Deque<Integer> deque) {
        if (deque.size() == M) {
            for (int number : deque) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            
            return;
        }

        for (int i = 1; i <= N; i ++) {
            deque.addLast(i);
            solve(deque);
            deque.pollLast();
        }
    }
}