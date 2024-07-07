import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        int result = calculate(numbers);

        System.out.println(result);

    }

    public static int calculate(int[] numbers) {
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(isPrime(numbers[i])) {
                count += 1;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}