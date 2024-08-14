import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    private static int[][] map;

    private static boolean[][] visited;

    private static int N = 0;

    //상하좌우로만 가능해서
    private static int[][] distances = new int[][] {
            {0,1}, //동
            {0,-1},//서
            {-1,0},//남
            {1,0}  //북
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i ++) {
            String[] numbers = br.readLine().split("");

            for(int j = 0; j < N; j ++) {
                //정사각형이니까 굳이 numbers.length로 해서 한번 더 계산하게 할 필요가 없음
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    answer.add(dfs(i,j));
                }
            }
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for(int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row,col});
        visited[row][col] = true;

        int count = 1;

        while(!stack.isEmpty()) {
            int[] currentCoordinate = stack.pop();
            int currentRow = currentCoordinate[0];
            int currentCol = currentCoordinate[1];

            visited[currentRow][currentCol] = true;

            for(int[] distance : distances) {
                int newRow = currentRow + distance[0];
                int newCol = currentCol + distance[1];

                if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N &&
                map[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    stack.push(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    count += 1;
                }
            }
        }

        return count;
    }
}