import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            int[] s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            dfs(s, 0, 0, new int[6]);
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    private static void dfs(int[] arr, int start, int depth, int[] result) {
        if (depth == 6) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 0; i < 6; i++) {
                sj.add(String.valueOf(result[i]));
            }
            sb.append(sj).append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            dfs(arr, i + 1, depth + 1, result);
        }
    }

}
