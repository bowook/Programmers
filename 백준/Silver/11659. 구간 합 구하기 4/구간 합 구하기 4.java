import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] numbers = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        List<Long> dp = new ArrayList<>();
        dp.add(numbers[0]);

        for(int i = 1; i < N; i ++) {
            dp.add(dp.get(i-1) + numbers[i]);
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken())-1;
            int endPoint = Integer.parseInt(st.nextToken())-1;

            if(startPoint == 0) {
                sb.append(dp.get(endPoint)).append("\n");
                continue;
            }

            sb.append(dp.get(endPoint) - dp.get(startPoint-1)).append("\n");
        }

        System.out.println(sb);
    }
}