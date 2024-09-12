import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R,C;
    private static String[][] grassland;
    private static boolean[][] visited;

    private static int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        R = Integer.parseInt(st.nextToken()); //row
        C = Integer.parseInt(st.nextToken()); //col
        grassland = new String[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R;  i++) {
            String[] inputs = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                grassland[i][j] = inputs[j];
            }
        }

        for(int i = 0; i < R; i ++) {
            for(int j = 0; j < C; j ++) {
                if(!visited[i][j] && grassland[i][j].equals("#")) {
                    bfs(i,j);
                    result += 1;
                }
            }
        }

        System.out.println(result);


    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow>=0 && newRow<R && newCol >= 0 && newCol<C && !visited[newRow][newCol]
                && grassland[newRow][newCol].equals("#")) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}