import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //그림에서 M개 이하의 종이가 올려져있으면 그림이보임
        int count = 0;

        int[][] picture = new int[101][101];

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int leftUnderX = Integer.parseInt(st.nextToken());
            int leftUnderY = Integer.parseInt(st.nextToken());
            int rightTopX = Integer.parseInt(st.nextToken());
            int rightTopY = Integer.parseInt(st.nextToken());

            for(int j = leftUnderX; j <= rightTopX; j ++) {
                for(int k = leftUnderY; k <= rightTopY; k ++) {
                    picture[j][k] += 1;
                }
            }
        }

        for(int i = 1; i <= 100; i ++) {
            for(int j = 1; j <= 100; j ++) {
                if(picture[i][j] > M) count++;
            }
        }

        System.out.println(count);
    }
}