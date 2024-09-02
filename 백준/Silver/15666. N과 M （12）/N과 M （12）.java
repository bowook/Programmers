import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static int[] valueByDetph;
    private static int N,M;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //자연수 개수
        M = Integer.parseInt(st.nextToken()); //중 M개 고르기
        st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        valueByDetph = new int[M];

        for(int i = 0; i < N; i ++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int idx) {
        if(depth == M) {
            for(int i = 0; i < M; i ++) {
                sb.append(valueByDetph[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;

        for(int i = idx; i < N; i ++) {
            int current = numbers[i];
            if(current != before) {
                before = current;
                valueByDetph[depth] = current;
                dfs(depth+1, i);
            }
        }

    }
}