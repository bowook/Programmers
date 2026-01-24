import java.util.*;
import java.io.*;

class Main {

    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int[] results;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        results = new int[M];
        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i ++) {
                sb.append(results[i])
                    .append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                results[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
                results[depth] = 0;
            }
        }
    }
}

