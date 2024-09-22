import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][] visited;
    private static int minCount = Integer.MAX_VALUE;
    private static boolean found = false;

    private static int[][] directions = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        visited[r][c] = true;
        dfs(r, c, 0, 0);

        if (found) {
            System.out.println(minCount);
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(int row, int col, int apples, int depth) {
        if(apples == 3) {
            found = true;
            minCount = Math.min(minCount, depth);
            return;
        }

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5 && !visited[newRow][newCol] && board[newRow][newCol] != -1) {
                visited[newRow][newCol] = true;
                if(board[newRow][newCol] == 1) {
                    dfs(newRow, newCol, apples + 1, depth + 1);
                }
                else {
                    dfs(newRow, newCol, apples, depth + 1);
                }
                visited[newRow][newCol] = false;
            }
        }
    }
}