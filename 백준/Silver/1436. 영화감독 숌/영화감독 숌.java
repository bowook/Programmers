import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int result = calculate(N);

        System.out.println(result);
    }

    public static int calculate(int N) {
        int count = 0;
        int number = 1;
        while(count != N) {
            number += 1;
            if(String.valueOf(number).contains("666")) {
                count+=1;
            }
        }

        return number;
    }
}