import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> dp = new ArrayList<>();

        dp.add(1L);
        dp.add(3L);

        for(int i = 2; i < 1000; i ++) {
            dp.add(dp.get(i-1) + dp.get(i-2) * 2);
            dp.set(i, dp.get(i) % 10007);
        }

        System.out.println(dp.get(N-1));
    }
}