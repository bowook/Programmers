import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MIN_VALUE;
    private static int N;
    private static int M;
    private static int[][] paper;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                visited[i][j] = true;
                dfs(1, i, j, paper[i][j]); //count, row, column, value
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int count, int row, int column, int value){
        if(count == 4) {
            answer = Math.max(answer, value);
            return;
        }


        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = column + direction[1];

            if(newRow < 0 || newRow >= N || newCol < 0 || newCol >= M || visited[newRow][newCol]) {
                continue;
            }
            visited[newRow][newCol] = true;

            if(count == 2) {
                //ㅏ, ㅓ, ㅗ, ㅜ 때문에
                dfs(count+1, row, column, value + paper[newRow][newCol]);
            }

            dfs(count+1, newRow, newCol, value + paper[newRow][newCol]);

            //Backtracking이라서 방문했던곳을 다시 취소해줘야됨
            visited[newRow][newCol] = false;
        }
    }
}