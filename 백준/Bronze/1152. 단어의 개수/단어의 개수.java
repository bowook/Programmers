import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().trim();
        String[] arr = str.split(" ");

        int length = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].isEmpty()) {
                continue;
            }
            length += 1;
        }
        System.out.println(length);
    }
}