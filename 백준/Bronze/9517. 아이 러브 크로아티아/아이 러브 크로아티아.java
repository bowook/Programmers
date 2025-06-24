import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boomTime = 210;
        int receivedUserNumber = Integer.parseInt(br.readLine());
        int questions = Integer.parseInt(br.readLine());
        int elapsedTime = 0;
        for (int question = 0; question < questions; question++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            elapsedTime += Integer.parseInt(st.nextToken());
            String isCorrect = st.nextToken();
            if (elapsedTime >= boomTime) {
                break;
            }
            if (isCorrect.equals("T")) {
                receivedUserNumber++;
                if (receivedUserNumber == 9) {
                    receivedUserNumber = 1;
                }
            }
        }

        System.out.println(receivedUserNumber);
    }
}
