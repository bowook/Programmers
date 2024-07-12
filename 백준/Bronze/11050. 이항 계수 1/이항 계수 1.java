import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //N! / k! (N-K)!
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        int result = combination(N,K);

        System.out.println(result);

    }

    public static int combination(int N, int K) {
        int nFactorial = factorial(N);
        int kFactorial = factorial(K);
        int nMinusKFactorial = factorial(N-K);

        return nFactorial/(kFactorial*nMinusKFactorial);

    }

    public static int factorial(int number) {
        int sum = 1;
        for(int i = number; i > 0; i--) {
            sum *= i;
        }

        return sum;
    }
}