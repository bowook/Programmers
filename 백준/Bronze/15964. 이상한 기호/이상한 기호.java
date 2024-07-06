
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //A＠B = (A+B)×(A-B)
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] numbers = new int[arr.length];
        numbers[0] = Integer.parseInt(arr[0]);
        numbers[1] = Integer.parseInt(arr[1]);

        long result = calculate(numbers[0], numbers[1]);

        System.out.println(result);
    }

    public static long calculate(int A, int B) {
        return (long) (A + B) *(A-B);
    }
}