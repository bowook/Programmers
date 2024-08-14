import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //0은 이동할 수 없는 칸, 1은 이도할 수 있는 칸
    //출발지는 (1,1)
    private static int[][] puzzle;

    //visited를 따로 사용하면 메모리 초과 뜸.. 그러면
    //private static boolean[][] visited;
    private static int endRow = 0;
    private static int endCol = 0;
    private static final int[][] directions = {
            {0, 1},   // 동
            {0, -1},  // 서
            {-1, 0},  // 남
            {1, 0}    // 북
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        endRow= Integer.parseInt(st.nextToken());
        endCol= Integer.parseInt(st.nextToken());

        puzzle = new int[endRow][endCol];

        for(int i = 0; i < endRow; i ++) {
            String[] numbers = br.readLine().split("");
            for(int j = 0; j < endCol; j ++) {
                puzzle[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int result = bfs(0,0);

        System.out.println(result);

    }

    public static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        puzzle[row][col] = row + col + 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentRow = current[0];
            int currentCol = current[1];
            int currentDistance = puzzle[currentRow][currentCol];

            if(currentRow == endRow -1 && currentCol == endCol -1) {
                return currentDistance;
            }


            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                if(newRow>=0 && newRow < endRow && newCol >=0 && newCol < endCol && puzzle[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow,newCol});
                    //그냥 puzzle을 이용해야할듯
                    puzzle[newRow][newCol] = puzzle[currentRow][currentCol] + 1;
                }

            }
        }
        return -1;
    }
}