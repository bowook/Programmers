import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Long> dp = new ArrayList<>();

        dp.add(1L);
        dp.add(1L);
        dp.add(1L);
        for(int i = 3; i <= 100; i ++) {
            dp.add(dp.get(i-2) + dp.get(i-3));
        }

        for(int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp.get(N-1));
        }
    }
}