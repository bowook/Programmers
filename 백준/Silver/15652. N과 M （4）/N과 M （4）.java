import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr;

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //1부터 N까지 수 중에서
        M = Integer.parseInt(st.nextToken()); //M개 고르기 -> Depth로 인식
        arr = new int[M];
        dfs(1,0);

        System.out.println(sb);

    }

    private static void dfs(int value, int depth) {
        if(depth == M)  {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = value; i <= N; i ++) {
            arr[depth] = i;
            dfs(i,depth+1);
        }
    }
}