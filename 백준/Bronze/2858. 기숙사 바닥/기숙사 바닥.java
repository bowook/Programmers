import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int R = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);

        int[] result = calculate(R,B);

        for(int i = 0; i < result.length; i ++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] calculate(int R, int B) {
        int total = R + B;

        for (int h = 3; h <= total / 2; h++) {
            if (total % h == 0) {
                int w = total / h;
                if (2 * w + 2 * h - 4 == R) {
                    return new int[]{w, h};
                }
            }
        }

        return new int[]{};

    }
}