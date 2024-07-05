import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[N];
        for(int i = 0; i < N; i ++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int v = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        for(int i = 0; i < N; i ++) {
            if(v == numbers[i]) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}