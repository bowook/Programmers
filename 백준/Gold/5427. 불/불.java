import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final String EMPTY_SPACE = ".";
    private static final String WALL_SPACE = "#";
    private static final String START_SPACE = "@";
    private static final String FIRE = "*";
    private static final String IMPOSSILBE = "IMPOSSIBLE";
    private static final int[][] directions = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    private static StringBuilder sb = new StringBuilder();
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            visited = new boolean[row][col];
            String[][] building = new String[row][col];
            int myRow = 0;
            int myCol = 0;
            for (int j = 0; j < row; j ++) {
                String[] values = br.readLine().split("");

                for (int k = 0; k < col; k ++) {
                    String value = values[k];
                    building[j][k] = value;
                    if (value.equals(START_SPACE)) {
                        myRow = j;
                        myCol = k;
                    }
                    
                }
            }
            
            bfs(myRow, myCol, building);
        }

        System.out.println(sb);
    }

    private static void bfs(int row, int col, String[][] building) {
        int[][] fireTime = new int[building.length][building[0].length];
        for (int i = 0; i < fireTime.length; i ++) {
            for (int j = 0; j < fireTime[0].length; j++) {
                fireTime[i][j] = Integer.MAX_VALUE;
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < building.length; i ++) {
            for (int j = 0; j < building[0].length; j ++) {
                if (building[i][j].equals(FIRE)) {
                    deque.addLast(new int[]{i, j, 0});
                    fireTime[i][j] = 0;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentTime = current[2];
            
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < building.length && newCol >= 0 && newCol < building[0].length
                   && !building[newRow][newCol].equals(WALL_SPACE) && fireTime[newRow][newCol] == Integer.MAX_VALUE) {
                    deque.addLast(new int[]{newRow, newCol, currentTime + 1});
                    fireTime[newRow][newCol] = currentTime + 1;
                   }
            }
        }

        //그러면 이제 불이 다 번진 상태임. 번진 곳에는 몇 초에 번졌는지 기록되어 있음
        deque.addLast(new int[]{row, col, 0});
        visited[row][col] = true;
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentCount = current[2];

            if (currentRow == building.length-1 || currentRow == 0 || currentCol == building[0].length-1 || currentCol == 0) {
                sb.append(currentCount + 1)
                    .append("\n");

                return;
            }

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < building.length && newCol >= 0 && newCol < building[0].length
                   && !visited[newRow][newCol] && building[newRow][newCol].equals(EMPTY_SPACE)
                   && currentCount + 1 < fireTime[newRow][newCol]) {
                    deque.addLast(new int[]{newRow, newCol, currentCount + 1});
                    visited[newRow][newCol] = true;
                   }
            }
        }

        sb.append(IMPOSSILBE)
            .append("\n");

    }
}