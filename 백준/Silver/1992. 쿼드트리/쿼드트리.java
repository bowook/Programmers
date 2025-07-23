import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    private static int[][] matrix;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        recursive(0, 0, N);

        System.out.println(sb);
    }

    private static void recursive(final int row, final int col, final int x) {
        //모두 같은 숫자인지
        if (isSameNumber(row, col, x)) {
            int number = matrix[row][col];
            sb.append(number);

            return;
        }

        int half = x / 2;
        sb.append(LEFT);

        recursive(row, col, half);
        recursive(row, col + half, half);
        recursive(row + half, col, half);
        recursive(row + half, col + half, half);
        
        sb.append(RIGHT);
    }

    private static boolean isSameNumber(final int row, final int col, final int x) {
        int number = matrix[row][col];
        for (int i = row; i < row + x; i++) {
            for (int j = col; j < col + x; j++) {
                if (matrix[i][j] != number) {
                    return false;
                }
            }
        }

        return true;
    }
}

