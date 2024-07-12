import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int humans = Integer.parseInt(arr[0]);
        int xy = Integer.parseInt(arr[1]);
        String[] newspaper = scanner.nextLine().split(" ");

        int total = humans * xy;

        int[] result = calculate(total, newspaper);

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] calculate(int total, String[] newspaper) {
        int[] temp = new int[newspaper.length];

        for(int i = 0; i < newspaper.length; i ++) {
            int num = Integer.parseInt(newspaper[i]);
            temp[i] = num - total;
        }

        return temp;
    }
}