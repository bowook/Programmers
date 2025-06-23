import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int users = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int throwRules = Integer.parseInt(st.nextToken());

        int throwCounts = 0;
        int receiveUser = 1;
        int[] receiveBallCounts = new int[users + 1];
        receiveBallCounts[receiveUser] = 1;

        while (true) {
            int receiveCounts = receiveBallCounts[receiveUser];
            if (receiveCounts == max) {
                break;
            }
            if (receiveCounts % 2 == 0) {
                // 짝수
                receiveUser -= throwRules;
                if (receiveUser <= 0) {
                    receiveUser = users + receiveUser;
                }
            } else {
                // 홀수
                receiveUser += throwRules;
                if (receiveUser > users) {
                    receiveUser -= users;
                }
            }
            receiveBallCounts[receiveUser]++;
            throwCounts++;
        }

        System.out.println(throwCounts);
    }
}
