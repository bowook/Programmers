import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] numbers = new int[count];
        for(int i = 0; i < count; i ++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        int min = minCalculate(numbers);
        int max = maxCalculate(numbers);

        System.out.print(String.valueOf(min) + " " + String.valueOf(max));

    }

    public static int minCalculate(int[] numbers) {
        int min = 1000000;
        for(int i = 0; i < numbers.length; i ++) {
            if(min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int maxCalculate(int[] numbers) {
        int max = -1000000;
        for(int i = 0; i < numbers.length; i ++) {
            if(max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }
}