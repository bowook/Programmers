import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int qusghks = Integer.parseInt(str);
        int result = calculate(qusghks);
        System.out.println(result);
    }

    public static int calculate(int result) {
        return result - 543;
    }
}