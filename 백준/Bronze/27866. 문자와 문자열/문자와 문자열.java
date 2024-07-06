import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int str_index = scanner.nextInt();
        scanner.nextLine();

        char result = compare(str, str_index-1);

        System.out.println(result);
    }

    public static char compare(String str, int str_index){
        return str.charAt(str_index);
    }
}