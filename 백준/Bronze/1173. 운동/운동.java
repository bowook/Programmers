import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //운동 시간
        int m = Integer.parseInt(st.nextToken()); //초기 맥박
        int M = Integer.parseInt(st.nextToken()); //맥박의 최대치
        int T = Integer.parseInt(st.nextToken()); //운동 선택하면 T맥박 증가
        int R = Integer.parseInt(st.nextToken()); //휴식 선택하면 R맥박 감소

        if (m > M || (m + T > M && m - R < m)) {
            System.out.println("-1");
            return;
        }

        int exerciseCount = 0;
        int minute = 0;
        int mInit = m;
        while (exerciseCount != N) {
            if (m + T > M) {
                // 휴식 선택
                m -= R;
                if (m < mInit) {
                    m = mInit;
                }
                minute++;
                continue;
            }
            m += T;
            exerciseCount++;
            minute++;
        }

        System.out.println(minute);
    }
}
