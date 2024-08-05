import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int width, length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new int[length][width];
            visited = new boolean[length][width];

            for(int j = 0; j < K; j ++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[Y][X] = 1;
            }

            int count = 0;

            for (int j = 0; j < length; j++) {
                for (int k = 0; k < width; k++) {
                    if (field[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        //경계 체크
        if (x < 0 || x >= length || y < 0 || y >= width) return;
        //배추가 없거나 이미 방문했으면 탐색할 필요가 없으니까 return
        if (field[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true; //현재 위치 방문 처리

        //상하좌우 탐색
        //흠.. 근데 여기서 x랑 y가 0,0 이거나 그러면 마이너스 인덱스가 들어갈탠데
        //아 그러면 위에서 경계선을 잡아주면 되겠네

        //하고 이제 여기서 상하좌우 탐색
        dfs(x, y+1);
        dfs(x, y-1);
        dfs(x-1, y);
        dfs(x+1, y);
    }
}