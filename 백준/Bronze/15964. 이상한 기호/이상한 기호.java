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

        int result = calculate(numbers[0], numbers[1]);

        System.out.println(result);
    }

    public static int calculate(int A, int B) {
        return (A+B)*(A-B);
    }
}