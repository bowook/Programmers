import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BigInteger A = scanner.nextBigInteger();
        BigInteger B = scanner.nextBigInteger();

        StringBuilder sb = new StringBuilder();

        sb.append(A.add(B)).append("\n");
        sb.append(A.subtract(B)).append("\n");
        sb.append(A.multiply(B));

        System.out.println(sb);
    }
}