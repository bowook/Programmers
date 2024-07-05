import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        scanner.nextLine();
        int num2 = scanner.nextInt();
        scanner.nextLine();

        int[] numbers = calculate(num1, num2);

        for(int i = 0; i < 4; i++) {
            System.out.println(numbers[i]);
        }

    }

    public static int[] calculate(int num1, int num2) {
        int last = num2 % 10;
        int middle = (num2 % 100) / 10;
        int first = num2 / 100;

        int[] numbers = new int[4];
        numbers[0] = num1 * last;
        numbers[1] = num1 * middle;
        numbers[2] = num1 * first;
        numbers[3] = numbers[0] + (numbers[1] * 10) + (numbers[2]*100);
        return numbers;

    }
}