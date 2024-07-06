import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCase; i ++) {
            String str = scanner.nextLine();

            System.out.println(String.valueOf(str.charAt(0))+String.valueOf(str.charAt(str.length()-1)));
        }
    }
}