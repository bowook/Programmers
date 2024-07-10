import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //낮에 A, 밤에 B, 정상 V
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        int days = calculateDays(A, B, V);

        System.out.println(days);
    }

    public static int calculateDays(int A, int B, int V) {
        int remainingDistance = V - A;
        int dailyClimb = A - B;

        int days = (int) Math.ceil((double) remainingDistance / dailyClimb);

        return days + 1;
    }
}