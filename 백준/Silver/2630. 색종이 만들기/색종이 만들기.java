import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] paper;
    private static int blueCounts = 0;
    private static int whiteCounts = 0;

    //정사각형
    //N은 한 변의 길이, 등비수열
    //하얀색으으로 칠해진 칸은 0, 파란색을로 칠해진 칸은 1
    //각 숫자 사이에는 빈칸이 하나씩 있다.

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
        System.out.println(whiteCounts);
        System.out.println(blueCounts);
    }

    private static void recursive(int row, int col, int x) {
        //모두 같은 색인지 봐야함
        if (isSameColor(row, col, x)) {
            int color = paper[row][col];
            if (color == 0) {
                whiteCounts += 1;
            } else if (color == 1) {
                blueCounts += 1;
            }
            return;
        }

        int half = x / 2;
        recursive(row, col, half);
        recursive(row, col + half, half);
        recursive(row + half, col, half);
        recursive(row + half, col + half, half);
    }

    private static boolean isSameColor(final int row, final int col, final int x) {
        int color = paper[row][col];
        for (int i = row; i < row + x; i++) {
            for (int j = col; j < col + x; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
