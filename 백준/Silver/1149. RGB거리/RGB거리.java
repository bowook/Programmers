import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]); //i번째 집을 빨간색
            //현재 집을 빨간색으로 칠할때의 비용이 이전 집의 초록색과 파란색 중 최소 비용을 더한 값
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]); //i번째 집을 초록색
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]); //i번째 집을 파란색
        }

        System.out.println(Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2])));
    }
}