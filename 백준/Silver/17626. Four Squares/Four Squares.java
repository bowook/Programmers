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
        dp.add(1);

        for(int i = 2; i <= 50000; i ++) {
            dp.add(i,Integer.MAX_VALUE);
            for(int j = 1; j * j <=i; j ++) {
                dp.set(i, Math.min(dp.get(i),dp.get(i-j*j) + 1));
            }
        }

        System.out.println(dp.get(N));
    }
}