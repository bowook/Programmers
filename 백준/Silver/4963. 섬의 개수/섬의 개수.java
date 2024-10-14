import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
            {1,1},
            {-1,-1},
            {1,-1},
            {-1,1}
    };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                System.out.println(sb.toString().trim());
                return;
            }

            int[][] map = input(w,h,br);


            boolean[][] visited = new boolean[h][w];

            int result = 0;
            for(int i = 0; i < h; i ++) {
                for(int j = 0; j < w; j ++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        result += 1;
                        dfs(i,j,map,visited,h,w);
                    }
                }
            }
            sb.append(result).append("\n");
        }
    }
    private static void dfs(int row, int col, int[][] map, boolean[][] visited, int maxRow, int maxCol) {
        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || visited[row][col] || map[row][col] == 0) {
            return;
        }

        visited[row][col] = true;

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            dfs(newRow, newCol, map, visited, maxRow, maxCol);
        }
    }
    private static int[][] input(int w, int h, BufferedReader br) throws IOException{
        int[][] map = new int[h][w];
        for(int i = 0; i < h; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;

    }
}