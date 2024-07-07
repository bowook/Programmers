import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if (str.equals("0 0 0")) {
                break;
            }
            String[] arr = str.split(" ");
            int[] numbers = new int[arr.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(numbers);

            if (numbers[2] * numbers[2] == numbers[0] * numbers[0] + numbers[1] * numbers[1]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}