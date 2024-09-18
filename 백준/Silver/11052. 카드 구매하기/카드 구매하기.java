import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //카드의 개수
        int[] cardPacks = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i ++) {
            cardPacks[i] = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+cardPacks[j]);
            }
        }

        System.out.println(dp[N]);



    }
}