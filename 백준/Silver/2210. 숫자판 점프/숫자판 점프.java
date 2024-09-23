import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];

        for (int i = 0; i < 5; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j ++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                dfs(i,j,1,String.valueOf(board[i][j]));
            }
        }

        System.out.println(set.size());
    }
    private static void dfs(int row, int col, int depth, String current) {
        if (depth == 6) {
            set.add(current);
            return;
        }
        for(int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5) {
                dfs(newRow, newCol, depth +1, current + board[newRow][newCol]);
            }
        }
    }
}