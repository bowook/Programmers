import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //.은 땅, #은 울타리, o는 양, v는 늑대
    private static int[][] directions = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    private static int R,C,liveSheep, liveWolf;
    private static String[][] ground;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ground = new String[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i ++) {
            String[] inputs = br.readLine().split("");
            for(int j = 0; j < C; j ++) {
                ground[i][j] = inputs[j];
            }
        }

        br.close();

        for(int i = 0; i < R; i ++) {
            for(int j = 0; j < C; j++) {
                if(!ground[i][j].equals("#") && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        System.out.println(liveSheep +" " + liveWolf);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int areaSheep = 0;
        int areaWolf = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            if(ground[currentRow][currentCol].equals("o")) {
                areaSheep += 1;
            }
            else if (ground[currentRow][currentCol].equals("v")) {
                areaWolf += 1;
            }
            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow>=0 && newRow < R && newCol >= 0 && newCol < C && !visited[newRow][newCol] &&
                !ground[newRow][newCol].equals("#")) {
                    if(ground[newRow][newCol].equals("o")) {
                        queue.offer(new int[]{newRow, newCol});
                    }
                    else if (ground[newRow][newCol].equals("v")) {
                        queue.offer(new int[]{newRow,newCol});
                    }
                    else {
                        queue.offer(new int[]{newRow, newCol});
                    }
                    visited[newRow][newCol] = true;
                }
            }
        }

        if(areaSheep > areaWolf) {
            liveSheep += areaSheep;
        }
        else {
            liveWolf += areaWolf;
        }
    }
}