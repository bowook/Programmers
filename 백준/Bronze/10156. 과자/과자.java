import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        int needMoney = numbers[0] * numbers[1];
        if(needMoney <= numbers[2]) {
            System.out.println(0);
        }
        else {
            System.out.println(needMoney - numbers[2]);
        }
    }
}