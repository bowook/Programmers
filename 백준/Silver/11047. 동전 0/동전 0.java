import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken());
        int K = Integer.parseInt(firstLine.nextToken());
        int[] coins = new int[N];
        for(int i = 0; i < N; i ++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int remain = K;
        int totalCount = 0;
        for(int i = N-1; i >= 0; i --) {
            if(remain - coins[i] >= 0) {
                int tempCount = remain / coins[i];
                remain = remain - (coins[i] * tempCount);
                totalCount += tempCount;
                if(remain == 0) {
                    break;
                }
            }
        }

        System.out.println(totalCount);
    }
}