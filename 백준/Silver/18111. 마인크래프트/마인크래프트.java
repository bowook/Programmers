import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //존재하는 블록 중
    //가장 작은 층에서 존재하는 블록중 가장 높은 층 상에 범위만 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//세로
        int M = Integer.parseInt(st.nextToken());//가로
        int B = Integer.parseInt(st.nextToken());//인벤토리에 들어있는 블록의 개수

        //블록을 인벤에 넣는데 걸리는 시간은 2초
        //블록을 인벤에서 꺼내서 설치하는데 걸리는 시간은 1초
        int[][] blocksHeight = new int[N][M];

        int min = 257;
        int max = -1;

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                blocksHeight[i][j] = Integer.parseInt(st.nextToken());

                if(min > blocksHeight[i][j]) {
                    min = blocksHeight[i][j];
                }

                if(max < blocksHeight[i][j]) {
                    max = blocksHeight[i][j];
                }
            }
        }

        int optimalHeight = -1;
        int minTime = Integer.MAX_VALUE;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = blocksHeight[i][j] - h;

                    if (diff > 0) { // 블록을 제거해야 하는 경우
                        time += diff * 2;
                        inventory += diff;
                    } else if (diff < 0) { // 블록을 추가해야 하는 경우
                        time -= diff;
                        inventory += diff;
                    }
                }
            }

            if (inventory >= 0 && time <= minTime) {
                minTime = time;
                optimalHeight = h;
            }
        }

        System.out.println(minTime + " " + optimalHeight);


    }
}