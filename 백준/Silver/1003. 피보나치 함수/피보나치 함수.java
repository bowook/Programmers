import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i ++) {
            int number = Integer.parseInt(br.readLine());
            StringBuilder result = fibonacci(number);

            System.out.println(result);
        }
    }

    public static StringBuilder fibonacci(int number) {
        List<Integer> dp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dp.add(0);
        dp.add(1);

        for(int i = 2; i <= number; i++) {
            dp.add(dp.get(i-1) + dp.get(i-2));
        }

        if (number == 0) {
            return sb.append(1).append(" ").append(0);
        }

        return sb.append(dp.get(number-1)).append(" ").append(dp.get(number));
    }

}