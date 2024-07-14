import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //5의 배수마다 0이 생김

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        while (N >= 5) {
            count += N/5;
            N /= 5;
        }

        System.out.println(count);


    }
}