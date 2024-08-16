import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    private static int[][] graph;
    private static int N = 0;

    private static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); //vertex 개수

        graph = new int[N][N];
        answer = new int[N][N];

        for(int i = 0; i < N; i ++) {
            String[] numbers = br.readLine().split(" ");
            for(int j = 0; j < N; j ++) {
                graph[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1) {
                    dfs(i,j);
                }
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int row, int col) {
        boolean[][] visited = new boolean[N][N];
        answer[row][col] = 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        while(!stack.isEmpty()) {
            int[] currentCoordinate = stack.pop();
            int endPointVertex = currentCoordinate[1];

            //startVertex -> endPointVertex로 갈 수 있는거니까
            for(int i = 0; i < N; i ++) {
                if (graph[endPointVertex][i] == 1 && !visited[endPointVertex][i]) {
                    stack.push(new int[]{endPointVertex,i});
                    visited[endPointVertex][i] = true;
                    answer[row][i] = 1;
                }
            }
        }
    }
}