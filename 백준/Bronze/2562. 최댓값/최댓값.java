import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = scanner.nextInt();
        scanner.nextLine();

        int count = 0;

        for(int i = 1; i < 9; i ++) {
            int temp = scanner.nextInt();
            scanner.nextLine();

            if(temp > max) {
                max = temp;
                count = i;
            }
        }
        System.out.println(max);
        System.out.println(count+1);
    }
}