import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()); // 수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[A];
        int[] dp = new int[A];

        for (int i = 0; i < A; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < A; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // LIS의 최대 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < A; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}