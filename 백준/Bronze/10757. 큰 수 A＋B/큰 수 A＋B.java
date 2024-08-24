import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] numbers = line.split(" ");

        BigInteger num1 = new BigInteger(numbers[0]);
        BigInteger num2 = new BigInteger(numbers[1]);

        System.out.println(num1.add(num2));
    }
}