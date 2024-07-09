import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int k = scanner.nextInt(); // 층수
            int n = scanner.nextInt(); // 호수

            int[][] floor = new int[k + 1][n + 1];

            // 0층 만들기
            for (int j = 1; j <= n; j++) {
                floor[0][j] = j;
            }

            // 1층 이상 만들기
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= n; m++) {
                    floor[j][m] = floor[j][m - 1] + floor[j - 1][m];
                }
            }

            // k층 n호 출력
            System.out.println(floor[k][n]);
        }

        scanner.close();
    }
}