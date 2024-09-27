import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int minXY = Math.min(X, Y);
        int maxXY = Math.max(X, Y);

        //전부 직선
        long result1 = (long) (X + Y) * W;

        //대각선 + 직선
        long result2 = (long) minXY * S + (long) (maxXY - minXY) * W;

        //대각선으로만 이동하거나 남은 거리도 대각선
        long result3;
        if ((X + Y) % 2 == 0) {  // X + Y가 짝수면 대각선
            result3 = (long) maxXY * S;
        } else {  // X + Y가 홀수면 남은 1칸은 직선 이동
            result3 = (long) (maxXY - 1) * S + W;
        }

        //최소값을 선택
        long result = Math.min(result1, Math.min(result2, result3));

        System.out.println(result);
    }
}
