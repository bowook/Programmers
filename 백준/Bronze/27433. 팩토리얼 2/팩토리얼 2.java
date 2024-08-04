import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println(1);
            return;
        }

        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 1; i <= N; i ++) sum = sum.multiply(BigInteger.valueOf(i));

        System.out.println(sum);
    }
}