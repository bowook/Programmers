import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] timer = new int[arr.length];
        timer[0] = Integer.parseInt(arr[0]);
        timer[1] = Integer.parseInt(arr[1]);

        if(timer[1] < 45) {
            timer[1] = timer[1] + 60 - 45;
            timer[0] = timer[0] -1;
            if(timer[0] == -1) {
                timer[0] = 23;
            }
        }
        else {
            timer[1] = timer[1] - 45;
        }

        System.out.print(timer[0] + " ");
        System.out.print(timer[1]);
    }
}