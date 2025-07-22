import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] paper;
    private static int minus = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void recursive(int row, int col, int x) {
        if (isSameNumber(row, col, x)) {
            int number = paper[row][col];
            if (number == 0) {
                zero += 1;
            } else if (number == 1) {
                one += 1;
            } else {
                minus += 1;
            }

            return;
        }

        int newX = x / 3;

        recursive(row, col, newX);
        recursive(row, col + newX, newX);
        recursive(row, col + newX * 2, newX);

        recursive(row + newX, col, newX);
        recursive(row + newX, col + newX, newX);
        recursive(row + newX, col + newX * 2, newX);

        recursive(row + newX * 2, col, newX);
        recursive(row + newX * 2, col + newX, newX);
        recursive(row + newX * 2, col + newX * 2, newX);
    }

    private static boolean isSameNumber(final int row, final int col, final int x) {
        int number = paper[row][col];
        for (int i = row; i < x + row; i++) {
            for (int j = col; j < x + col; j++) {
                if (number != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}

