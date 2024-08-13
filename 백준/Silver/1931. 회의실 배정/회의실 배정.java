import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 회의의 개수
        int[][] conferenceTime = new int[N][2];

        // 회의 시간 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferenceTime[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            conferenceTime[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        //conferenceTime의 endTime이 빠른순으로 정렬해야하고, 같을경우 시작시간이 빠른 순으로 정렬
        Arrays.sort(conferenceTime, Comparator.comparingInt((int[] time) -> time[1])
                .thenComparingInt(time -> time[0]));


        int counts = 0;
        int endTime = 0;

        for(int i = 0; i < conferenceTime.length; i ++) {
            if(conferenceTime[i][0] >= endTime) {
                //이거 >=으로 해줘야됨. endTime이 시작시간인 회의실이 있을 수 잇으니까...
                counts += 1;
                endTime = conferenceTime[i][1];
            }
        }

        System.out.println(counts);
    }
}