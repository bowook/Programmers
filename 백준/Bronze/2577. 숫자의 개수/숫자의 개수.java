import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];

        int num1 = scanner.nextInt();
        scanner.nextLine();

        int num2 = scanner.nextInt();
        scanner.nextLine();

        int num3 = scanner.nextInt();
        scanner.nextLine();

        String total = String.valueOf(num1 * num2 * num3);

        for(int i = 0; i < total.length(); i ++) {
            numbers[Integer.parseInt(String.valueOf(total.charAt(i)))] += 1;
        }
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}