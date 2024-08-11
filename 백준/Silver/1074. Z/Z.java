import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int targetRowNumber = Integer.parseInt(st.nextToken());
        int targetColNumber = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,N);

        //DFS 방식을하면 격자형에서는 시간복잡도가 ON^2이 되어버림
        //차라리 타겟행과 타겟 열을 주고, 값을 계산해버리자

        dfs(targetRowNumber,targetColNumber,size);

        System.out.println(answer);

    }

    private static void dfs(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;

        //2사분면일때
        if(row < newSize && col < newSize) {
            dfs(row, col, newSize);
        }
        else if(row < newSize && col >= newSize) {
            answer += size * size / 4;
            dfs(row, col- newSize, newSize);
        }
        else if(row >= newSize && col < newSize) {
            answer += (size * size / 4) * 2;
            dfs(row - newSize, col, newSize);
        }
        else {
            answer += (size * size / 4) * 3;
            dfs(row - newSize, col - newSize, newSize);
        }
    }
}