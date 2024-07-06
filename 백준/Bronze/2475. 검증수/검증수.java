import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] numbers = new int[arr.length];
        int sum = 0;
        for(int i = 0; i < arr.length; i ++) {
            numbers[i] = Integer.parseInt(arr[i]) * Integer.parseInt(arr[i]);
            sum += numbers[i];
        }

        int result = calculate(sum);

        System.out.println(result);

    }

    public static int calculate(int sum) {
        return sum % 10;
    }

}