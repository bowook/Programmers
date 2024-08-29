import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static boolean[] visited;
    private static int[] valueByDepths;
    private static int N,M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        visited = new boolean[N];
        valueByDepths = new int[N];

        for(int i = 0; i < N; i ++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i ++) {
                sb.append(valueByDepths[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                valueByDepths[depth] = numbers[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

}