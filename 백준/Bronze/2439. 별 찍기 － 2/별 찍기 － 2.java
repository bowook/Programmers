import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < line; i ++) {
            for(int j = line-1-i; j > 0; j --) {
                System.out.print(" ");
            }
            for(int k = 0; k < i+1; k ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}