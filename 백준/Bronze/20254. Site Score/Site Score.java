import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        int sum = calculate(numbers);

        System.out.println(sum);


    }

    public static int calculate(int[] numbers){
        return (numbers[0] * 56) + (numbers[1] * 24) + (numbers[2] * 14) + (numbers[3] * 6);
    }
}