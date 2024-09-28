import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        long mod = 20000303;

        long result = 0;
        for (int i = 0; i < input.length(); i++) {
            result = (result * 10 + (input.charAt(i) - '0')) % mod;
        }

        System.out.println(result);
    }
}