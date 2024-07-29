import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> dp = new ArrayList<>();

        dp.add(0);
        dp.add(0);

        for(int i = 2; i <= N; i ++) {
            dp.add(dp.get(i-1) + 1);

            if(i % 2 == 0) {
                dp.set(i, Math.min(dp.get(i), dp.get(i/2) + 1));
            }

            if(i % 3 == 0) {
                dp.set(i, Math.min(dp.get(i), dp.get(i/3) + 1));
            }
        }

        System.out.println(dp.get(N));
    }
}