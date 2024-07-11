import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 라인에서 N과 M을 입력받습니다.
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 두 번째 라인에서 A를 입력받습니다.
        String A = scanner.next();

        // 세 번째 라인에서 B를 입력받습니다.
        String B = scanner.next();

        // BigInteger를 사용하여 큰 숫자를 처리합니다.
        BigInteger numA = new BigInteger(A);
        BigInteger numB = new BigInteger(B);

        // A와 B의 곱을 계산합니다.
        BigInteger result = numA.multiply(numB);

        // 결과를 출력합니다.
        System.out.println(result);

        scanner.close();
    }
}
