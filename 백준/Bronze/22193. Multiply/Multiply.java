import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int[] num1 = new int[arr[0].length()];
        int[] num2 = new int[arr[1].length()];

        num1[0] = scanner.nextInt();
        scanner.nextLine();

        num2[0] = scanner.nextInt();
        scanner.nextLine();

        System.out.println(num1[0] * num2[0]);
    }
}