import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] numbers = new int[arr.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        String result = compare(numbers);

        System.out.println(result);
    }

    public static String compare(int[] numbers){
        int num1 = numbers[0];
        int num2 = numbers[1];
        String result = "";
        if(num1 > num2) {
            result = ">";
        }
        else if(num1 < num2) {
            result = "<";
        }
        else {
            result = "==";
        }
        return result;
    }
}