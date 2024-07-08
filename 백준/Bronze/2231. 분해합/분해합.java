import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        boolean flag = false;
        for(int i = 0;i < N; i ++) {
            String tempNumber = String.valueOf(i);
            String[] arr = tempNumber.split("");
            int[] numbers = new int[arr.length];
            int sum = 0;
            for(int j = 0; j < numbers.length; j ++) {
                numbers[j] = Integer.parseInt(arr[j]);
                sum += numbers[j];
            }
            if(i + sum == N) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println(0);
        }
    }
}