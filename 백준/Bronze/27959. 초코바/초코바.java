import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        int[] numbers = new int[2];

        for(int i = 0; i < 2; i ++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        String result = calculate(numbers);

        System.out.println(result);

    }

    public static String calculate(int[] numbers){
        String result = "";

        int purchaseCase = (numbers[0] * 100) - numbers[1];

        if(purchaseCase < 0) {
            result = "No";
        }
        else {
            result = "Yes";
        }


        return result;
    }
}