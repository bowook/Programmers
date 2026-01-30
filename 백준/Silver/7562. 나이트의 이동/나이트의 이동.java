import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final int[][] directions = new int[][]{
        {-1,2},
        {-2,1},
        {-1,-2},
        {-2,-1},
        {1,2},
        {2,1},
        {1,-2},
        {2,-1}
    };
    
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases; i ++) {
            int[][] board;
            for (int j = 0; j < 1; j ++) {
                int length = Integer.parseInt(br.readLine());
                board = new int[length][length];
                visited = new boolean[length][length];
                
                StringTokenizer st = new StringTokenizer(br.readLine());
                int currentRow = Integer.parseInt(st.nextToken());
                int currentCol = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                int targetRow = Integer.parseInt(st.nextToken());
                int targetCol = Integer.parseInt(st.nextToken());

                int counts = bfs(currentRow, currentCol, targetRow, targetCol);
                sb.append(counts)
                    .append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static int bfs(int row, int col, int targetRow, int targetCol) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row, col, 0});
        visited[row][col] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentCount = current[2];

            if (currentRow == targetRow && currentCol == targetCol) {
                return currentCount;
            }

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < visited.length && newCol >= 0 && newCol < visited[0].length
                   && !visited[newRow][newCol]) {
                    deque.addLast(new int[]{newRow, newCol, currentCount + 1});
                    visited[newRow][newCol] = true;
                   }
            }
        }

        return 0;
    }
}