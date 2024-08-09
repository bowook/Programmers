import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] campus;
    private static boolean[][] visited;

    private static int N;
    private static int M;

    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int startPointRow = 0;
        int startPointCol = 0;

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
                visited[i][j] = false;

                if(campus[i][j] == 'I') {
                    startPointRow = i;
                    startPointCol = j;
                }
            }
        }

        dfs(startPointRow,startPointCol);

        if(count == 0) {
            System.out.println("TT");
            return;
        }

        System.out.println(count);
    }

    public static void dfs(int row, int col) {
        if((row < 0 || col < 0 || row >= N || col >= M) || visited[row][col]) {
            return;
        }

        if(campus[row][col] == 'X') {
            return;
        }
        else if(campus[row][col] == 'P') {
            count++;
        }

        visited[row][col] = true;
        dfs(row-1,col); //상
        dfs(row,col-1); //좌
        dfs(row+1,col); //하
        dfs(row,col+1); //우

    }
}