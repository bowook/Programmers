import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first_num = scanner.nextInt();
        scanner.nextLine();

        int second_num = scanner.nextInt();
        scanner.nextLine();

        int third_num = scanner.nextInt();
        scanner.nextLine();

        int result_num = calculate_integer(first_num, second_num, third_num);
        int result_str = calculate_str(String.valueOf(first_num), String.valueOf(second_num), third_num);

        System.out.println(result_num);
        System.out.println(result_str);


    }

    public static int calculate_integer(int first_num, int second_num, int third_num) {
        int result =(first_num+second_num)-third_num;;
        return result;
    }

    public static int calculate_str(String first_num, String second_num, int third_num) {
        return Integer.parseInt(first_num + second_num) - third_num;
    }
}