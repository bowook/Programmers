import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();

        double L = Math.sqrt(2 * W);
        
        double perimeter = 4 * L;
        
        System.out.println((int) perimeter);
    }
}
