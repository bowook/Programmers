

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] inputNumbers;
    private static int[] valueByDepth;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputNumbers = new int[N];
        valueByDepth = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(inputNumbers);

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(valueByDepth[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            
            if (visited[i] || (i > 0 && inputNumbers[i] == inputNumbers[i - 1] && !visited[i - 1])) {
                continue;
            }

            visited[i] = true;
            valueByDepth[depth] = inputNumbers[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
